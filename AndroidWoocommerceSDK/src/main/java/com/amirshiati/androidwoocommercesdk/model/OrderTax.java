package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class OrderTax implements Serializable {

    private long id;
    private String rateCode;
    private String rateId;
    private String label;
    private boolean compound;
    private String taxTotal;
    private String shippingTaxTotal;

    public OrderTax(long id, String rateCode, String rateId, String label, boolean compound, String taxTotal, String shippingTaxTotal) {
        this.id = id;
        this.rateCode = rateCode;
        this.rateId = rateId;
        this.label = label;
        this.compound = compound;
        this.taxTotal = taxTotal;
        this.shippingTaxTotal = shippingTaxTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCompound() {
        return compound;
    }

    public void setCompound(boolean compound) {
        this.compound = compound;
    }

    public String getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
    }

    public String getShippingTaxTotal() {
        return shippingTaxTotal;
    }

    public void setShippingTaxTotal(String shippingTaxTotal) {
        this.shippingTaxTotal = shippingTaxTotal;
    }
}
