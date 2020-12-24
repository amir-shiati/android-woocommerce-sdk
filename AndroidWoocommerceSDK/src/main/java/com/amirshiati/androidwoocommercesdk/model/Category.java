package com.amirshiati.androidwoocommercesdk.model;

import com.amirshiati.androidwoocommercesdk.enums.CategoryDisplay;

import java.io.Serializable;

public class Category implements Serializable {
    private long id;
    private String name;
    private String slug;
    private long parent;
    private String description;
    private CategoryDisplay display;
    private Image image;
    private long menuOrder;
    private long count;

    public Category(long id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public Category(long id, String name, String slug, long parent, String description, CategoryDisplay display, Image image, long menuOrder, long count) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.parent = parent;
        this.description = description;
        this.display = display;
        this.image = image;
        this.menuOrder = menuOrder;
        this.count = count;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDisplay getDisplay() {
        return display;
    }

    public void setDisplay(CategoryDisplay display) {
        this.display = display;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public long getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(long menuOrder) {
        this.menuOrder = menuOrder;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
