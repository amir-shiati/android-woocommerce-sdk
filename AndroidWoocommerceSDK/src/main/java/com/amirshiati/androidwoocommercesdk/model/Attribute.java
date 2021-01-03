package com.amirshiati.androidwoocommercesdk.model;

import com.amirshiati.androidwoocommercesdk.enums.AttributeOrderBy;

import java.io.Serializable;

public class Attribute implements Serializable {
    private Long id;
    private String name;
    private String slug;
    private AttributeOrderBy orderBy;
    private boolean hasArchives;

    public Attribute(Long id, String name, String slug, AttributeOrderBy orderBy, boolean hasArchives) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.orderBy = orderBy;
        this.hasArchives = hasArchives;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public AttributeOrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(AttributeOrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isHasArchives() {
        return hasArchives;
    }

    public void setHasArchives(boolean hasArchives) {
        this.hasArchives = hasArchives;
    }
}
