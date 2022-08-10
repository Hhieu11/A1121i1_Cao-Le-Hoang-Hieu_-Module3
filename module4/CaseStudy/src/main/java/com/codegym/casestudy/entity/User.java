package com.codegym.casestudy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

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

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Employee> employees;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;


    public User() {
    }

    public User(Integer id, String userName, String password, List<Employee> employees, List<UserRole> userRoles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.employees = employees;
        this.userRoles = userRoles;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}