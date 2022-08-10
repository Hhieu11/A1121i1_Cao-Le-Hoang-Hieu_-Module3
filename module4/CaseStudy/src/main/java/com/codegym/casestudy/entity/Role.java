package com.codegym.casestudy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role",
        uniqueConstraints = @UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Id", nullable = false)
    private Integer id;
    @Column(name = "Role_Name", nullable = false)
    private String roleName;

    @JsonBackReference
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role() {
    }

    public Role(Integer id, String roleName, List<UserRole> userRoles) {
        this.id = id;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
