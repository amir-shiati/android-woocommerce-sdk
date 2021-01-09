package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderShippingLine implements Serializable {

    private long id;
    private String methodTitle;
    private String methodId;
    private String total;
    private String totalTax;
    private ArrayList<OrderTax> taxes;

    public OrderShippingLine(long id, String methodTitle, String methodId, String total, String totalTax, ArrayList<OrderTax> taxes) {
        this.id = id;
        this.methodTitle = methodTitle;
        this.methodId = methodId;
        this.total = total;
        this.totalTax = totalTax;
        this.taxes = taxes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMethodTitle() {
        return methodTitle;
    }

    public void setMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public ArrayList<OrderTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<OrderTax> taxes) {
        this.taxes = taxes;
    }
}
