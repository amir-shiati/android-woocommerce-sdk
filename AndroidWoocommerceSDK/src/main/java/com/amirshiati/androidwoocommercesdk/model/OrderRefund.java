package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class OrderRefund implements Serializable {

    private long id;
    private String reason;
    private String total;

    public OrderRefund(long id, String reason, String total) {
        this.id = id;
        this.reason = reason;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
