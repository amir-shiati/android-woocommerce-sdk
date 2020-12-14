package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class ProductDimensions implements Serializable {

    private String length;
    private String width;
    private String height;

    public ProductDimensions(String length, String width, String height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
