package com.amirshiati.androidwoocommercesdk.model;

import com.amirshiati.androidwoocommercesdk.enums.ProductBackOrdered;
import com.amirshiati.androidwoocommercesdk.enums.ProductCatalogVisibility;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.amirshiati.androidwoocommercesdk.enums.TaxStatus;

import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<ProductDownloadProperties> productDownloadProperties;
    private long downloadLimit;
    private long downloadExpiry;
    private String externalUrl;
    private String buttonText;
    private TaxStatus taxStatus;
    private String taxClass;
    private boolean manageStock;
    private long stockQuantity;
    private ProductStockStatus stockStatus;
    private ProductBackOrdered backOrders;
    private boolean backOrdersAllowed;
    private boolean backOrdered;
    private boolean soldIndividually;
    private String weight;
    private ProductDimensions dimensions;
    private boolean shippingRequired;
    private boolean shippingTaxable;
    private String shippingClass;
    private long shippingClassId;
    private boolean reviewsAllowed;
    private String averageRating;
    private long ratingCount;
    private ArrayList<Long> relatedIds;
    private ArrayList<Long> upSellIds;
    private ArrayList<Long> crossSellIds;
    private long parentId;
    private String purchaseNote;
    private ArrayList<Category> categories;
    private ArrayList<Tag> tags;

    public Product(Long id, String name, String slug, String permaLink, Date dateCreated, Date dateModified, ProductType type, ProductStatus status, boolean featured, ProductCatalogVisibility catalogVisibility, String description, String shortDescription, String sku, String price, String regularPrice, String salePrice, Date onSaleFrom, Date onSaleTo, String priceHtml, boolean onSale, boolean purchasable, long totalSales, boolean virtual, boolean downloadable, ArrayList<ProductDownloadProperties> productDownloadProperties, long downloadLimit, long downloadExpiry, String externalUrl, String buttonText, TaxStatus taxStatus, String taxClass, boolean manageStock, long stockQuantity, ProductStockStatus stockStatus, ProductBackOrdered backOrders, boolean backOrdersAllowed, boolean backOrdered, boolean soldIndividually, String weight, ProductDimensions dimensions, boolean shippingRequired, boolean shippingTaxable, String shippingClass, long shippingClassId, boolean reviewsAllowed, String averageRating, long ratingCount, ArrayList<Long> relatedIds, ArrayList<Long> upSellIds, ArrayList<Long> crossSellIds, long parentId, String purchaseNote, ArrayList<Category> categories, ArrayList<Tag> tags) {
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
        this.productDownloadProperties = productDownloadProperties;
        this.downloadLimit = downloadLimit;
        this.downloadExpiry = downloadExpiry;
        this.externalUrl = externalUrl;
        this.buttonText = buttonText;
        this.taxStatus = taxStatus;
        this.taxClass = taxClass;
        this.manageStock = manageStock;
        this.stockQuantity = stockQuantity;
        this.stockStatus = stockStatus;
        this.backOrders = backOrders;
        this.backOrdersAllowed = backOrdersAllowed;
        this.backOrdered = backOrdered;
        this.soldIndividually = soldIndividually;
        this.weight = weight;
        this.dimensions = dimensions;
        this.shippingRequired = shippingRequired;
        this.shippingTaxable = shippingTaxable;
        this.shippingClass = shippingClass;
        this.shippingClassId = shippingClassId;
        this.reviewsAllowed = reviewsAllowed;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.relatedIds = relatedIds;
        this.upSellIds = upSellIds;
        this.crossSellIds = crossSellIds;
        this.parentId = parentId;
        this.purchaseNote = purchaseNote;
        this.categories = categories;
        this.tags = tags;
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
