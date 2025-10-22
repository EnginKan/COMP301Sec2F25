package com.yeditepe.firstspingproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Community {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "communities")
    private Set<User> users;

    public Community() {}

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {return this.description;}
    public void setUsers(Set<User> users) {this.users = users;}
    public Set<User> getUsers() {return this.users;}

}
