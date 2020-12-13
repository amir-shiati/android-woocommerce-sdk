package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String name;
    private String slug;
    private String permaLink;

    public Product(Long id, String name, String slug, String permaLink) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.permaLink = permaLink;
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

    public String getPermaLink() {
        return permaLink;
    }

    public void setPermaLink(String permaLink) {
        this.permaLink = permaLink;
    }
}
