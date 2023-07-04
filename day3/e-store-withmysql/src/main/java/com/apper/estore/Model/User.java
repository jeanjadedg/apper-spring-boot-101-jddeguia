package com.apper.estore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String id;

    private String email;
    private String password;
}
