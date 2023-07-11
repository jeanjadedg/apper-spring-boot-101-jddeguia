package com.apper.theblogservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="BLOGGER")
@Data
public class Blogger {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "COMPLETE_NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;
}
