package com.apper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();

    public Account create(String firstName, String lastName, String userName, String clearPassword) {
        Account account = new Account();
        String id = UUID.randomUUID().toString();
        account.setId(id);
        System.out.println("Generated ID: " + id);
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

    public Account get(String id) {
        for (Account account: accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }
//
//    public void update() {}
//
//    public void delete() {}
}
