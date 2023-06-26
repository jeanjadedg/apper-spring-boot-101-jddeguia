package com.apper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();
    private IdGeneratorService generatorService;

    public AccountService(IdGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    public Account create(String firstName, String lastName, String username, String clearPassword) {
        Account account = new Account();

        String id = generatorService.nextId();
        account.setId(id);
        account.setBalance(1_000.0);

        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setLastUpdated(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);
        account.setVerificationCode(generatorService.givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect(6));

        accounts.add(account);

        return account;
    }

    public Account get(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    public List<Account> getAll() {
        return accounts;
    }

    public void update(String accountId, String firstName, String lastName, String username, String clearPassword) {
        Account account = get(accountId);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);
        account.setLastUpdated(LocalDateTime.now());
        accounts.set(accounts.indexOf(account), account);
    }

    public void delete(String accountId) {
        Account account = get(accountId);
        accounts.remove(account);
    }
}
