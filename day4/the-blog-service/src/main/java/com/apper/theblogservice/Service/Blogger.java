package com.apper.theblogservice.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BLOGGER")
@Data
public class Blogger {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "COMPLETE_NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;
}
