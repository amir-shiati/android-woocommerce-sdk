package com.amirshiati.androidwoocommercesdk.model;

import com.amirshiati.androidwoocommercesdk.enums.ProductCatalogVisibility;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Long id;
    private String name;
    private String slug;
    private String permaLink;
    private Date dateCreated;
    private Date dateModified;
    private ProductType type;
    private ProductStatus status;
    private boolean featured;
    private ProductCatalogVisibility catalogVisibility;
    private String description;
    private String shortDescription;
    private String sku;
    private String price;
    private String regularPrice;
    private String salePrice;
    private Date onSaleFrom;
    private Date onSaleTo;
    private String priceHtml;
    private boolean onSale;
    private boolean purchasable;
    private long totalSales;
    private boolean virtual;
    private boolean downloadable;

    public Product(Long id, String name, String slug, String permaLink, Date dateCreated, Date dateModified, ProductType type, ProductStatus status, boolean featured, ProductCatalogVisibility catalogVisibility, String description, String shortDescription, String sku, String price, String regularPrice, String salePrice, Date onSaleFrom, Date onSaleTo, String priceHtml, boolean onSale, boolean purchasable, long totalSales, boolean virtual, boolean downloadable) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.permaLink = permaLink;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.type = type;
        this.status = status;
        this.featured = featured;
        this.catalogVisibility = catalogVisibility;
        this.description = description;
        this.shortDescription = shortDescription;
        this.sku = sku;
        this.price = price;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.onSaleFrom = onSaleFrom;
        this.onSaleTo = onSaleTo;
        this.priceHtml = priceHtml;
        this.onSale = onSale;
        this.purchasable = purchasable;
        this.totalSales = totalSales;
        this.virtual = virtual;
        this.downloadable = downloadable;
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
