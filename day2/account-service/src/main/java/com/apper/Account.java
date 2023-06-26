package com.apper;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Account {
    private double balance;
    private String id;

    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    private String verificationCode;
}


