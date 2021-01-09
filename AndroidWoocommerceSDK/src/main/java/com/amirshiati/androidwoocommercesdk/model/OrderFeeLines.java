package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderFeeLines implements Serializable {

    private long id;
    private String name;
    private String taxClass;
    private String taxStatus;
    private String total;
    private String totalTax;
    private ArrayList<OrderTax> taxes;

    public OrderFeeLines(long id, String name, String taxClass, String taxStatus, String total, String totalTax, ArrayList<OrderTax> taxes) {
        this.id = id;
        this.name = name;
        this.taxClass = taxClass;
        this.taxStatus = taxStatus;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
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
