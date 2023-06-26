package com.apper;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();
    public Account create(String firstName, String lastName, String userName, String clearPassword) {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setBalance(1_000.00);

        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setCreationDate(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUserName(userName);
        account.setPassword(clearPassword);
        account.setVerificationCode("QW345T");

        accounts.add(account);

        return account;

    }

//    public Account get() {}
//
//    public void update() {}
//
//    public void delete() {}
}
