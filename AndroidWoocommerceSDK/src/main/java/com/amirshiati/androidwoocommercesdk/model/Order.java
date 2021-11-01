package com.amirshiati.androidwoocommercesdk.model;

import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {

    private long id;
    private long parentId;
    private String number;
    private String orderKey;
    private String createdVia;
    private String version;
    private OrderStatus status;
    private String currency;
    private Date dateCreated;
    private Date dateModified;
    private String discountTotal;
    private String discountTax;
    private String shippingTotal;
    private String shippingTax;
    private String cartTax;
    private String total;
    private String totalTax;
    private boolean pricesIncludeTax;
    private long customerId;
    private String customerIpAddress;
    private String customerUserAgent;
    private String customerNote;
    private OrderBilling billing;
    private OrderShipping shipping;
    private String paymentMethod;
    private String paymentMethodTitle;
    private String transactionId;
    private Date datePaid;
    private Date dateCompleted;
    private String cartHash;
    private ArrayList<OrderLineItem> lineItems;
    private ArrayList<OrderTax> taxLines;
    private ArrayList<OrderShippingLine> shippingLines;
    private ArrayList<OrderFeeLines> feeLines;
    private ArrayList<OrderCouponLine> couponLines;
    private ArrayList<OrderRefund> refunds;

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, long parentId, String number, String orderKey, String createdVia, String version, OrderStatus status, String currency, Date dateCreated, Date dateModified, String discountTotal, String discountTax, String shippingTotal, String shippingTax, String cartTax, String total, String totalTax, boolean pricesIncludeTax, long customerId, String customerIpAddress, String customerUserAgent, String customerNote, OrderBilling billing, OrderShipping shipping, String paymentMethod, String paymentMethodTitle, String transactionId, Date datePaid, Date dateCompleted, String cartHash, ArrayList<OrderLineItem> lineItems, ArrayList<OrderTax> taxLines, ArrayList<OrderShippingLine> shippingLines, ArrayList<OrderFeeLines> feeLines, ArrayList<OrderCouponLine> couponLines, ArrayList<OrderRefund> refunds) {
        this.id = id;
        this.parentId = parentId;
        this.number = number;
        this.orderKey = orderKey;
        this.createdVia = createdVia;
        this.version = version;
        this.status = status;
        this.currency = currency;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.discountTotal = discountTotal;
        this.discountTax = discountTax;
        this.shippingTotal = shippingTotal;
        this.shippingTax = shippingTax;
        this.cartTax = cartTax;
        this.total = total;
        this.totalTax = totalTax;
        this.pricesIncludeTax = pricesIncludeTax;
        this.customerId = customerId;
        this.customerIpAddress = customerIpAddress;
        this.customerUserAgent = customerUserAgent;
        this.customerNote = customerNote;
        this.billing = billing;
        this.shipping = shipping;
        this.paymentMethod = paymentMethod;
        this.paymentMethodTitle = paymentMethodTitle;
        this.transactionId = transactionId;
        this.datePaid = datePaid;
        this.dateCompleted = dateCompleted;
        this.cartHash = cartHash;
        this.lineItems = lineItems;
        this.taxLines = taxLines;
        this.shippingLines = shippingLines;
        this.feeLines = feeLines;
        this.couponLines = couponLines;
        this.refunds = refunds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getCreatedVia() {
        return createdVia;
    }

    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
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

    public boolean isPricesIncludeTax() {
        return pricesIncludeTax;
    }

    public void setPricesIncludeTax(boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public OrderBilling getBilling() {
        return billing;
    }

    public void setBilling(OrderBilling billing) {
        this.billing = billing;
    }

    public OrderShipping getShipping() {
        return shipping;
    }

    public void setShipping(OrderShipping shipping) {
        this.shipping = shipping;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public ArrayList<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public ArrayList<OrderTax> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(ArrayList<OrderTax> taxLines) {
        this.taxLines = taxLines;
    }

    public ArrayList<OrderShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(ArrayList<OrderShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public ArrayList<OrderFeeLines> getFeeLines() {
        return feeLines;
    }

    public void setFeeLines(ArrayList<OrderFeeLines> feeLines) {
        this.feeLines = feeLines;
    }

    public ArrayList<OrderCouponLine> getCouponLines() {
        return couponLines;
    }

    public void setCouponLines(ArrayList<OrderCouponLine> couponLines) {
        this.couponLines = couponLines;
    }

    public ArrayList<OrderRefund> getRefunds() {
        return refunds;
    }

    public void setRefunds(ArrayList<OrderRefund> refunds) {
        this.refunds = refunds;
    }
}
