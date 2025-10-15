package com.yeditepe.firstspingproject.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="user_name",nullable=false,unique = true,
    length=20)
    private String username;
    private String password;
    public String email;


    //All entities must have no arg constructor
    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    //All entities must have getter/setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}