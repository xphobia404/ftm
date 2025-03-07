package com.nds.ftm.accounts.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nds.ftm.accounts.model.AccountsInput;
import com.nds.ftm.accounts.model.AccountsOutput;
import com.nds.ftm.entity.Accounts;
import com.nds.ftm.entity.Users;
import com.nds.ftm.repository.DaoAccounts;
import com.nds.ftm.repository.DaoUsers;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private DaoAccounts daoAccounts;

    @Autowired
    private DaoUsers daoUsers;

    public List<Accounts> list() {
        return daoAccounts.findAll();
    }

    public List<AccountsOutput> detail(AccountsInput input) throws Exception {
        log.debug("details [{}]", input);

        Optional<Users> userOptional = daoUsers.findById(input.getUserId());
        Users users = userOptional.orElseThrow(() -> new Exception("User not found"));

        List<Accounts> accounts = daoAccounts.findByUserId(input.getUserId());

        List<AccountsOutput> outputs = new ArrayList<>();
        for (Accounts account : accounts) {
            AccountsOutput output = new AccountsOutput();
            output.setAccountId(account.getAccountId());
            output.setUserId(account.getUserId());
            output.setBalance(account.getBalance());
            output.setCreated_at(account.getCreated_at());
            outputs.add(output);
        }

        return outputs;
    }


    @Transactional
    public AccountsOutput insert(AccountsInput input) throws Exception {
        log.debug("insert [{}]", input);

        Optional<Users> userOptional = daoUsers.findById(input.getUserId());

        Users user = userOptional.orElseThrow(() -> new Exception("User not found"));

        String uuid = UUID.randomUUID().toString();

        Accounts accounts = new Accounts();
        accounts.setAccountId(uuid);
        accounts.setUserId(user.getUserId());
        accounts.setBalance(input.getBalance());
        accounts.setCreated_at(LocalDateTime.now());

        daoAccounts.save(accounts);

        AccountsOutput output = new AccountsOutput();
        output.setAccountId(accounts.getAccountId());
        output.setUserId(accounts.getUserId());
        output.setBalance(accounts.getBalance());
        output.setCreated_at(accounts.getCreated_at());

        return output;
    }

    public List<Accounts> findAmount(AccountsInput input) throws Exception {
        log.debug("insert [{}]", input);

        List<Accounts> accounts = daoAccounts.searchAmount(input.getBalance());

        return accounts;
    }

}
