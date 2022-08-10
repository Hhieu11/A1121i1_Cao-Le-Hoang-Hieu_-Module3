package com.codegym.security.entity;

import javax.persistence.*;

@Entity
@Table(name = "User",
        uniqueConstraints = @UniqueConstraint(name = "USER_UK", columnNames = "User_Name"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Integer id;
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
    @Column(name = "Password", nullable = false)
    private String password;

    public User() {
    }

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
