package com.apper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        Account account = accountService.create(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword());

        CreateAccountResponse response = new CreateAccountResponse();
        response.setVerificationCode(account.getVerificationCode());

        return response;
    }

    @GetMapping("{accountId}")
    public GetAccountResponse getAccountResponse(@PathVariable String accountId) {
        Account account = accountService.get(accountId);
        GetAccountResponse response = new GetAccountResponse();

        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setUserName(account.getUserName());
        response.setCreationDate(account.getCreationDate());
        response.setBalance(account.getBalance());

        return response;

    }

}
