package com.apper;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetAccountResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private double balance;
    private LocalDateTime creationDate;

}
