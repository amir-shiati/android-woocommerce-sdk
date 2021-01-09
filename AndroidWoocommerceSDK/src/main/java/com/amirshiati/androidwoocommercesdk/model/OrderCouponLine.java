package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class OrderCouponLine implements Serializable {

    private long id;
    private String code;
    private String discount;
    private String discountTax;

    public OrderCouponLine(long id, String code, String discount, String discountTax) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.discountTax = discountTax;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }
}
