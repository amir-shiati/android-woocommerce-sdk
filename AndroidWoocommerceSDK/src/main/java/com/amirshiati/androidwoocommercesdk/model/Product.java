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
    private ArrayList<Image> images;
    private ArrayList<Attribute> attributes;
    private ArrayList<DefaultAttribute> defaultAttributes;
    private ArrayList<Long> variations;
    private ArrayList<Long> groupedProducts;
    private long menuOrder;

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String name, String permaLink, Date dateCreated, Date dateModified, ProductType type, ProductStatus status, boolean featured, String description, String shortDescription, String sku, String price, boolean onSale, boolean purchasable, boolean virtual, boolean downloadable, TaxStatus taxStatus, String taxClass, boolean manageStock, ProductStockStatus stockStatus, boolean soldIndividually, long shippingClassId, ArrayList<Category> categories, ArrayList<Tag> tags, ArrayList<Image> images, ArrayList<Attribute> attributes, ArrayList<Long> variations) {
        this.id = id;
        this.name = name;
        this.permaLink = permaLink;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.type = type;
        this.status = status;
        this.featured = featured;
        this.description = description;
        this.shortDescription = shortDescription;
        this.sku = sku;
        this.price = price;
        this.onSale = onSale;
        this.purchasable = purchasable;
        this.virtual = virtual;
        this.downloadable = downloadable;
        this.taxStatus = taxStatus;
        this.taxClass = taxClass;
        this.manageStock = manageStock;
        this.stockStatus = stockStatus;
        this.soldIndividually = soldIndividually;
        this.shippingClassId = shippingClassId;
        this.categories = categories;
        this.tags = tags;
        this.images = images;
        this.attributes = attributes;
        this.variations = variations;
    }

    public Product(Long id, String name, String slug, String permaLink, Date dateCreated, Date dateModified, ProductType type, ProductStatus status, boolean featured, ProductCatalogVisibility catalogVisibility, String description, String shortDescription, String sku, String price, String regularPrice, String salePrice, Date onSaleFrom, Date onSaleTo, String priceHtml, boolean onSale, boolean purchasable, long totalSales, boolean virtual, boolean downloadable, ArrayList<ProductDownloadProperties> productDownloadProperties, long downloadLimit, long downloadExpiry, String externalUrl, String buttonText, TaxStatus taxStatus, String taxClass, boolean manageStock, long stockQuantity, ProductStockStatus stockStatus, ProductBackOrdered backOrders, boolean backOrdersAllowed, boolean backOrdered, boolean soldIndividually, String weight, ProductDimensions dimensions, boolean shippingRequired, boolean shippingTaxable, String shippingClass, long shippingClassId, boolean reviewsAllowed, String averageRating, long ratingCount, ArrayList<Long> relatedIds, ArrayList<Long> upSellIds, ArrayList<Long> crossSellIds, long parentId, String purchaseNote, ArrayList<Category> categories, ArrayList<Tag> tags, ArrayList<Image> images, ArrayList<Attribute> attributes, ArrayList<DefaultAttribute> defaultAttributes, ArrayList<Long> variations, ArrayList<Long> groupedProducts, long menuOrder) {
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
        this.images = images;
        this.attributes = attributes;
        this.defaultAttributes = defaultAttributes;
        this.variations = variations;
        this.groupedProducts = groupedProducts;
        this.menuOrder = menuOrder;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public ProductCatalogVisibility getCatalogVisibility() {
        return catalogVisibility;
    }

    public void setCatalogVisibility(ProductCatalogVisibility catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Date getOnSaleFrom() {
        return onSaleFrom;
    }

    public void setOnSaleFrom(Date onSaleFrom) {
        this.onSaleFrom = onSaleFrom;
    }

    public Date getOnSaleTo() {
        return onSaleTo;
    }

    public void setOnSaleTo(Date onSaleTo) {
        this.onSaleTo = onSaleTo;
    }

    public String getPriceHtml() {
        return priceHtml;
    }

    public void setPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(long totalSales) {
        this.totalSales = totalSales;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public ArrayList<ProductDownloadProperties> getProductDownloadProperties() {
        return productDownloadProperties;
    }

    public void setProductDownloadProperties(ArrayList<ProductDownloadProperties> productDownloadProperties) {
        this.productDownloadProperties = productDownloadProperties;
    }

    public long getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(long downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public long getDownloadExpiry() {
        return downloadExpiry;
    }

    public void setDownloadExpiry(long downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public TaxStatus getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(TaxStatus taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public boolean isManageStock() {
        return manageStock;
    }

    public void setManageStock(boolean manageStock) {
        this.manageStock = manageStock;
    }

    public long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductStockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(ProductStockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public ProductBackOrdered getBackOrders() {
        return backOrders;
    }

    public void setBackOrders(ProductBackOrdered backOrders) {
        this.backOrders = backOrders;
    }

    public boolean isBackOrdersAllowed() {
        return backOrdersAllowed;
    }

    public void setBackOrdersAllowed(boolean backOrdersAllowed) {
        this.backOrdersAllowed = backOrdersAllowed;
    }

    public boolean isBackOrdered() {
        return backOrdered;
    }

    public void setBackOrdered(boolean backOrdered) {
        this.backOrdered = backOrdered;
    }

    public boolean isSoldIndividually() {
        return soldIndividually;
    }

    public void setSoldIndividually(boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public ProductDimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(ProductDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isShippingRequired() {
        return shippingRequired;
    }

    public void setShippingRequired(boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    public boolean isShippingTaxable() {
        return shippingTaxable;
    }

    public void setShippingTaxable(boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
    }

    public String getShippingClass() {
        return shippingClass;
    }

    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public long getShippingClassId() {
        return shippingClassId;
    }

    public void setShippingClassId(long shippingClassId) {
        this.shippingClassId = shippingClassId;
    }

    public boolean isReviewsAllowed() {
        return reviewsAllowed;
    }

    public void setReviewsAllowed(boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public long getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(long ratingCount) {
        this.ratingCount = ratingCount;
    }

    public ArrayList<Long> getRelatedIds() {
        return relatedIds;
    }

    public void setRelatedIds(ArrayList<Long> relatedIds) {
        this.relatedIds = relatedIds;
    }

    public ArrayList<Long> getUpSellIds() {
        return upSellIds;
    }

    public void setUpSellIds(ArrayList<Long> upSellIds) {
        this.upSellIds = upSellIds;
    }

    public ArrayList<Long> getCrossSellIds() {
        return crossSellIds;
    }

    public void setCrossSellIds(ArrayList<Long> crossSellIds) {
        this.crossSellIds = crossSellIds;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getPurchaseNote() {
        return purchaseNote;
    }

    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<DefaultAttribute> getDefaultAttributes() {
        return defaultAttributes;
    }

    public void setDefaultAttributes(ArrayList<DefaultAttribute> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    public ArrayList<Long> getVariations() {
        return variations;
    }

    public void setVariations(ArrayList<Long> variations) {
        this.variations = variations;
    }

    public ArrayList<Long> getGroupedProducts() {
        return groupedProducts;
    }

    public void setGroupedProducts(ArrayList<Long> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }

    public long getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(long menuOrder) {
        this.menuOrder = menuOrder;
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
