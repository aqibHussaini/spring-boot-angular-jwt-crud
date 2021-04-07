package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    public User() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;



    public User(int id, String user_name, String password) {
        this.id = id;
        this.userName = user_name;
        this.password = password;
    }
}
