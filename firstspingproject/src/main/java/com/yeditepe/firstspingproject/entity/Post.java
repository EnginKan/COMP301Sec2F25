package com.yeditepe.firstspingproject.entity;


import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="Title")
    private String title;
    private String content;
    @ManyToOne
    private User author;

    public Post(){}
    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
