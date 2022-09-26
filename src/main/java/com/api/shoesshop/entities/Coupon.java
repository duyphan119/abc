package com.api.shoesshop.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "percent_discount")
    private int percentDiscount;

    @Column(name = "price_discount")
    private int priceDiscount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "code", nullable = false)
    private String code;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPercentDiscount() {
        return this.percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getPriceDiscount() {
        return this.priceDiscount;
    }

    public void setPriceDiscount(int priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
