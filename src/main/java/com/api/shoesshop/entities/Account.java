package com.api.shoesshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "hashed_password", nullable = false)
    @JsonIgnore
    private String hashedPassword;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "account_role")
    private String accountRole;

    // @ManyToMany(cascade = { CascadeType.ALL })
    // @JoinTable(name = "product_accounts", joinColumns = {
    // @JoinColumn(name = "account_id_pk") }, inverseJoinColumns = {
    // @JoinColumn(name = "product_id_pk") })
    // List<Product> products = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }

    // public void setProducts(List<Product> products) {
    // this.products = products;
    // }

    // public List<Product> getProducts() {
    // return products;
    // }

}
