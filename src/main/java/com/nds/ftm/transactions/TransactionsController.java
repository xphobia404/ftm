package com.nds.ftm.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nds.ftm.entity.Transactions;
import com.nds.ftm.transactions.model.ReportOutput;
import com.nds.ftm.transactions.model.TransactionInput;
import com.nds.ftm.transactions.model.TransactionOutput;
import com.nds.ftm.transactions.service.TransactionService;

@RequestMapping("/transactions")
@RestController
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/list")
    public Page<Transactions> listPage(@RequestParam int page, @RequestParam int size) {
        return transactionService.listWithPagination(page, size);
    }

    @PostMapping(value = "/detail")
    public List<TransactionOutput> detail(@RequestBody TransactionInput input) throws Exception{
        return transactionService.detail(input);
    }

    @PostMapping(value = "/insert")
    public TransactionOutput insert(@RequestBody TransactionInput input) throws Exception{
        return transactionService.insert(input);
    }

    @PostMapping(value = "/report")
    public ReportOutput report(@RequestBody TransactionInput input) throws Exception{
        return transactionService.report(input);
    }
}
