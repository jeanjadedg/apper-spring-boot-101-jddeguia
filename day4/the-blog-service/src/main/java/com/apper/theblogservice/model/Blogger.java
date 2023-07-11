package com.apper.theblogservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdated;

    @PrePersist
    public void setCreatedAT() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        lastUpdated = now;
    }

    @PreUpdate
    public void setLastUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
