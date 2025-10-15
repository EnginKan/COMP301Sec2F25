package com.yeditepe.firstspingproject;

public class UserDTO {

    private int id;
    private String name;

    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public UserDTO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

//    public UserDTO(String name, String email) {
//        this.name = name;
//        this.email = email;
//    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
