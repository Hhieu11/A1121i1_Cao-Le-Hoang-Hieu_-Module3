package com.codegym.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Catelogy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catelogyId;

    @NotEmpty(message = "Khong dc de trong")
    private String catelogyName;

    @OneToMany(mappedBy = "catelogy",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> product;

    public Catelogy() {
    }

    public Catelogy(Integer catelogyId, @NotEmpty(message = "Khong dc de trong") String catelogyName, Set<Product> product) {
        this.catelogyId = catelogyId;
        this.catelogyName = catelogyName;
        this.product = product;
    }

    public Integer getCatelogyId() {
        return catelogyId;
    }

    public void setCatelogyId(Integer catelogyId) {
        this.catelogyId = catelogyId;
    }

    public String getCatelogyName() {
        return catelogyName;
    }



    public void setCatelogyName(String catelogyName) {
        this.catelogyName = catelogyName;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
