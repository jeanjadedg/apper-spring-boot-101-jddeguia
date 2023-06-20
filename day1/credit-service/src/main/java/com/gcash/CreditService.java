package com.gcash;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CreditService {
    private List<Account> accounts = new ArrayList<>();

    private final Account account;

    public CreditService(Account account) {
        this.account = account;
    }


    public Account createAccount(double initialBalance) {
        String accountId = UUID.randomUUID().toString();

        account.setId(accountId);
        account.setBalance(initialBalance);
        account.add(account);

        return account;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
    public void addBalance(String accountId, double amount) {
        for(Account account: accounts) {
            if(account.getId().equals(accountId)) {
                double newBalance = account.getBalance() + amount;
                account.setBalance(newBalance);

            }
        }

    }
}
