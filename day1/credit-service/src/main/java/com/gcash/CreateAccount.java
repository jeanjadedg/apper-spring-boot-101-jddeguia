package com.gcash;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CreateAccount {
    private double initialBalance;

}
