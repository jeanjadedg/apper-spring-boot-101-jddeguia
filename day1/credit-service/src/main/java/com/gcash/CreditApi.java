package com.gcash;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping
public class CreditApi {

    private final CreditService creditService;

    private final CreateAccount createAccount;


    public CreditApi(CreditService creditService, CreateAccount createAccount) {
        this.creditService = creditService;
        this.createAccount = createAccount;
    }

    @PostMapping
    public Account createNewAccount(@RequestBody CreditService creditService) {
        return creditService.createAccount(createAccount.getInitialBalance());

    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return creditService.getAllAccounts();
    }
}
