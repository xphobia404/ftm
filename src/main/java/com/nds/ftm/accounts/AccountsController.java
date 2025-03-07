package com.nds.ftm.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nds.ftm.accounts.model.AccountsInput;
import com.nds.ftm.accounts.model.AccountsOutput;
import com.nds.ftm.accounts.service.AccountService;
import com.nds.ftm.entity.Accounts;

@RequestMapping("/accounts")
@RestController
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/list")
    public List<Accounts> list() throws Exception {
        return accountService.list();
    }

    @PostMapping(value = "/detail")
    public List<AccountsOutput> detail(@RequestBody AccountsInput input) throws Exception{
        return accountService.detail(input);
    }

    @PostMapping(value = "/insert")
    public AccountsOutput insert(@RequestBody AccountsInput input) throws Exception{
        return accountService.insert(input);
    }

    @PostMapping(value = "/find")
    public List<AccountsOutput> findBalance(@RequestBody AccountsInput input) throws Exception{
        return accountService.findBalance(input);
    }
}
