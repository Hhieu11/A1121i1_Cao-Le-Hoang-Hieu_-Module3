package com.codegym.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotEmpty(message = "Ten khong duoc de trong")
    private String productCode;

    @NotEmpty(message = "Ten khong duoc de trong")
    private String productName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productBrithday;

    @Pattern(regexp = "^[\\w-\\.]+@(gmail.)+[com]{3,4}$", message = "email khong dung dinh dang")
    private String productEmail;

    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$", message = "CMND khong dung dinh dang")
    private String prodyctIdCard;

    @Column(columnDefinition = "bit")
    private int productGender;

    @ManyToOne
    @JoinColumn(name="catelogyId",nullable =false,referencedColumnName = "catelogyId")
    @JsonBackReference
    private Catelogy catelogy;

    public Product() {
    }

    public Product(Integer productId, @NotEmpty(message = "Ten khong duoc de trong") String productCode, @NotEmpty(message = "Ten khong duoc de trong") String productName, Date productBrithday, @Pattern(regexp = "^[\\w-\\.]+@(gmail.)+[com]{3,4}$", message = "email khong dung dinh dang") String productEmail, @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$", message = "CMND khong dung dinh dang") String prodyctIdCard, int productGender, Catelogy catelogy) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productBrithday = productBrithday;
        this.productEmail = productEmail;
        this.prodyctIdCard = prodyctIdCard;
        this.productGender = productGender;
        this.catelogy = catelogy;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductBrithday() {
        return productBrithday;
    }

    public void setProductBrithday(Date productBrithday) {
        this.productBrithday = productBrithday;
    }

    public String getProductEmail() {
        return productEmail;
    }

    public void setProductEmail(String productEmail) {
        this.productEmail = productEmail;
    }

    public String getProdyctIdCard() {
        return prodyctIdCard;
    }

    public void setProdyctIdCard(String prodyctIdCard) {
        this.prodyctIdCard = prodyctIdCard;
    }

    public int getProductGender() {
        return productGender;
    }

    public void setProductGender(int productGender) {
        this.productGender = productGender;
    }

    public Catelogy getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(Catelogy catelogy) {
        this.catelogy = catelogy;
    }
}
