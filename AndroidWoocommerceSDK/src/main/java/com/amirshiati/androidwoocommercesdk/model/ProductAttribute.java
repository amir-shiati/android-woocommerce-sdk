package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductAttribute implements Serializable {
    private Long id;
    private String name;
    private long position;
    private boolean visible;
    private boolean variation;
    private ArrayList<String> options;

    public ProductAttribute(Long id, String name, long position, boolean visible, boolean variation, ArrayList<String> options) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.visible = visible;
        this.variation = variation;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVariation() {
        return variation;
    }

    public void setVariation(boolean variation) {
        this.variation = variation;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
