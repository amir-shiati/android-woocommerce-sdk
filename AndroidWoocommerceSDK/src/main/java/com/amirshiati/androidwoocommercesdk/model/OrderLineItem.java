package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderLineItem implements Serializable {

    private long id;
    private String name;
    private long productItem;
    private long variationId;
    private long quantity;
    private String taxClass;
    private String subtotal;
    private String subtotalTax;
    private String total;
    private String totalTax;
    private ArrayList<OrderTax> taxes;
    private String sku;
    private String price;

    public OrderLineItem(long id, String name, long productItem, long variationId, long quantity, String taxClass, String subtotal, String subtotalTax, String total, String totalTax, ArrayList<OrderTax> taxes, String sku, String price) {
        this.id = id;
        this.name = name;
        this.productItem = productItem;
        this.variationId = variationId;
        this.quantity = quantity;
        this.taxClass = taxClass;
        this.subtotal = subtotal;
        this.subtotalTax = subtotalTax;
        this.total = total;
        this.totalTax = totalTax;
        this.taxes = taxes;
        this.sku = sku;
        this.price = price;
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

    public long getProductItem() {
        return productItem;
    }

    public void setProductItem(long productItem) {
        this.productItem = productItem;
    }

    public long getVariationId() {
        return variationId;
    }

    public void setVariationId(long variationId) {
        this.variationId = variationId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubtotalTax() {
        return subtotalTax;
    }

    public void setSubtotalTax(String subtotalTax) {
        this.subtotalTax = subtotalTax;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
