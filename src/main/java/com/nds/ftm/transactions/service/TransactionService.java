package com.nds.ftm.transactions.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nds.ftm.entity.Accounts;
import com.nds.ftm.entity.Transactions;
import com.nds.ftm.repository.DaoAccounts;
import com.nds.ftm.repository.DaoTransactions;
import com.nds.ftm.transactions.model.ReportOutput;
import com.nds.ftm.transactions.model.TransactionInput;
import com.nds.ftm.transactions.model.TransactionOutput;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionService {

    @Autowired
    private DaoAccounts daoAccounts;

    @Autowired
    private DaoTransactions daoTransactions;

    public Page<Transactions> listWithPagination(int page, int size) {
        return daoTransactions.findAll(PageRequest.of(page, size));
    }

    public List<TransactionOutput> detail(TransactionInput input) throws Exception {
        log.debug("details [{}]", input);

        Optional<Accounts> accountOptional = daoAccounts.findById(input.getAccountId());
        Accounts accounts = accountOptional.orElseThrow(() -> new Exception("Account not found"));

        List<Transactions> transactions = daoTransactions.findByAccountId(input.getAccountId());

        if (transactions.isEmpty()) {
            throw new Exception("No transactions found for this account");
        }

        List<TransactionOutput> outputs = new ArrayList<>();
        for (Transactions transaction : transactions) {
            TransactionOutput output = new TransactionOutput();
            output.setTransactionId(transaction.getTransactionId());
            output.setAccountId(transaction.getAccountId());
            output.setAmount(transaction.getAmount());
            output.setType(transaction.getType());
            output.setTimestamp(transaction.getTimestamp());
            outputs.add(output);
        }

        return outputs;
    }

    @Transactional
    public TransactionOutput insert(TransactionInput input) throws Exception {
        log.debug("insert [{}]", input);

        Optional<Accounts> accountOptional = daoAccounts.findById(input.getAccountId());

        Accounts accounts = accountOptional.orElseThrow(() -> new Exception("Account not found"));

        String uuid = UUID.randomUUID().toString();

        Transactions transaction = new Transactions();
        transaction.setTransactionId(uuid);
        transaction.setAccountId(accounts.getAccountId());
        transaction.setTimestamp(LocalDateTime.now());

        if (input.getType().equals("DEBIT")) {

            if (input.getAmount() > accounts.getBalance()) {
                throw new Exception("Balance not enough");
            }

            accounts.setBalance(accounts.getBalance() - input.getAmount());

            transaction.setAmount(input.getAmount());
            transaction.setType(input.getType());

        } else if (input.getType().equals("CREDIT")) {

            accounts.setBalance(accounts.getBalance() + input.getAmount());

            transaction.setAmount(input.getAmount());
            transaction.setType(input.getType());

        } else {
            throw new Exception("Type must be either DEBIT or CREDIT");
        }

        daoTransactions.save(transaction);
        daoAccounts.save(accounts);

        TransactionOutput output = new TransactionOutput();
        output.setTransactionId(transaction.getTransactionId());
        output.setAccountId(transaction.getAccountId());
        output.setAmount(transaction.getAmount());
        output.setType(transaction.getType());
        output.setTimestamp(transaction.getTimestamp());

        return output;
    }

    public ReportOutput report(TransactionInput input) throws Exception {
        log.debug("report [{}]", input);

        if (input.getStartDate() == null || input.getEndDate() == null) {
            throw new Exception("Both startDate and endDate must be provided");
        }

        List<Transactions> transactions = daoTransactions.findReport(
            input.getType(), input.getStartDate(), input.getEndDate()
        );

        Integer totalTransactions = transactions.size();
        Integer totalAmount = transactions.stream()
                                         .mapToInt(Transactions::getAmount)
                                         .sum();

        ReportOutput output = new ReportOutput();
        output.setType(input.getType());
        output.setTotalTransactions(totalTransactions);
        output.setTotalAmount(totalAmount);

        return output;
    }


}
