package com.amirshiati.androidwoocommercesdk.json;

import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.model.Order;
import com.amirshiati.androidwoocommercesdk.model.OrderBilling;
import com.amirshiati.androidwoocommercesdk.model.OrderCouponLine;
import com.amirshiati.androidwoocommercesdk.model.OrderFeeLines;
import com.amirshiati.androidwoocommercesdk.model.OrderLineItem;
import com.amirshiati.androidwoocommercesdk.model.OrderRefund;
import com.amirshiati.androidwoocommercesdk.model.OrderShipping;
import com.amirshiati.androidwoocommercesdk.model.OrderShippingLine;
import com.amirshiati.androidwoocommercesdk.model.OrderTax;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.amirshiati.androidwoocommercesdk.json.ProductJsonConverter.getLong;
import static com.amirshiati.androidwoocommercesdk.json.ProductJsonConverter.getString;

public class OrderJsonConverter {

    public static Order jsonToOrder(JSONObject toConvert) throws JSONException {
        return new Order(
                getLong(toConvert, "id"),
                getLong(toConvert, "parent_id"),
                getString(toConvert, "number"),
                getString(toConvert, "order_key"),
                getString(toConvert, "created_via"),
                getString(toConvert, "version"),
                //get order status
                jsonToOrderStatus(toConvert),
                getString(toConvert, "currency"),
                Utils.stringToDate(getString(toConvert, "date_created")),
                Utils.stringToDate(getString(toConvert, "date_modified")),
                getString(toConvert, "discount_total"),
                getString(toConvert, "discount_tax"),
                getString(toConvert, "shipping_total"),
                getString(toConvert, "shipping_tax"),
                getString(toConvert, "cart_tax"),
                getString(toConvert, "total"),
                getString(toConvert, "total_tax"),
                toConvert.getBoolean("prices_include_tax"),
                getLong(toConvert, "customer_id"),
                getString(toConvert, "customer_ip_address"),
                getString(toConvert, "customer_user_agent"),
                getString(toConvert, "customer_note"),
                //get order billing
                jsonToOrderBilling(toConvert),
                //get order shipping
                jsonToOrderShipping(toConvert),
                getString(toConvert, "payment_method"),
                getString(toConvert, "payment_method_title"),
                getString(toConvert, "transaction_id"),
                Utils.stringToDate(getString(toConvert, "date_paid")),
                Utils.stringToDate(getString(toConvert, "date_completed")),
                getString(toConvert, "cart_hash"),
                jsonToOrderLineItems(toConvert),
                jsonToOrderTaxes(toConvert.getJSONArray("tax_lines")),
                jsonToOrderShippingLines(toConvert),
                jsonToOrderFeeLines(toConvert),
                jsonToOrderCouponLines(toConvert),
                jsonToOrderRefunds(toConvert)
        );
    }

    public static ArrayList<OrderRefund> jsonToOrderRefunds(JSONObject toConvert) throws JSONException {
        ArrayList<OrderRefund> result = new ArrayList<>();
        JSONArray array = toConvert.getJSONArray("refunds");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderRefund(object));
        }

        return result;
    }

    public static OrderRefund jsonToOrderRefund(JSONObject toConvert) throws JSONException {
        return new OrderRefund(
                getLong(toConvert, "id"),
                getString(toConvert, "reason"),
                getString(toConvert, "total")
        );
    }

    public static ArrayList<OrderCouponLine> jsonToOrderCouponLines(JSONObject toConvert) throws JSONException {
        ArrayList<OrderCouponLine> result = new ArrayList<>();
        JSONArray array = toConvert.getJSONArray("coupon_lines");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderCouponLine(object));
        }

        return result;
    }

    public static OrderCouponLine jsonToOrderCouponLine(JSONObject toConvert) throws JSONException {
        return new OrderCouponLine(
                getLong(toConvert, "id"),
                getString(toConvert, "code"),
                getString(toConvert, "discount"),
                getString(toConvert, "discount_tax")
        );
    }

    public static ArrayList<OrderFeeLines> jsonToOrderFeeLines(JSONObject toConvert) throws JSONException {
        ArrayList<OrderFeeLines> result = new ArrayList<>();
        JSONArray array = toConvert.getJSONArray("fee_lines");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderFeeLine(object));
        }

        return result;
    }

    public static OrderFeeLines jsonToOrderFeeLine(JSONObject toConvert) throws JSONException {
        return new OrderFeeLines(
                getLong(toConvert, "id"),
                getString(toConvert, "name"),
                getString(toConvert, "tax_class"),
                getString(toConvert, "tax_status"),
                getString(toConvert, "total"),
                getString(toConvert, "total_tax"),
                jsonToOrderTaxes(toConvert.getJSONArray("tax_lines"))
        );
    }

    public static ArrayList<OrderShippingLine> jsonToOrderShippingLines(JSONObject toConvert) throws JSONException {
        ArrayList<OrderShippingLine> result = new ArrayList<>();
        JSONArray array = toConvert.getJSONArray("shipping_lines");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderShippingLine(object));
        }

        return result;
    }

    public static OrderShippingLine jsonToOrderShippingLine(JSONObject toConvert) throws JSONException {
        return new OrderShippingLine(
                getLong(toConvert, "id"),
                getString(toConvert, "method_title"),
                getString(toConvert, "method_id"),
                getString(toConvert, "total"),
                getString(toConvert, "total_tax"),
                jsonToOrderTaxes(toConvert.getJSONArray("tax_lines"))
        );
    }

    public static ArrayList<OrderLineItem> jsonToOrderLineItems(JSONObject toConvert) throws JSONException {
        ArrayList<OrderLineItem> result = new ArrayList<>();
        JSONArray array = toConvert.getJSONArray("line_items");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderLineItem(object));
        }

        return result;
    }

    public static OrderLineItem jsonToOrderLineItem(JSONObject toConvert) throws JSONException {
        return new OrderLineItem(
                getLong(toConvert, "id"),
                getString(toConvert, "name"),
                getLong(toConvert, "product_id"),
                getLong(toConvert, "variation_id"),
                getLong(toConvert, "quantity"),
                getString(toConvert, "tax_class"),
                getString(toConvert, "subtotal"),
                getString(toConvert, "subtotal_tax"),
                getString(toConvert, "total"),
                getString(toConvert, "total_tax"),
                //getting line item tax
                jsonToOrderTaxes(toConvert.getJSONArray("taxes")),
                getString(toConvert, "sku"),
                getString(toConvert, "price")
        );
    }

    public static ArrayList<OrderTax> jsonToOrderTaxes(JSONArray array) throws JSONException {
        ArrayList<OrderTax> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result.add(jsonToOrderTax(object));
        }

        return result;
    }

    public static OrderTax jsonToOrderTax(JSONObject toConvert) throws JSONException {
        return new OrderTax(
                getLong(toConvert, "id"),
                getString(toConvert, "rate_code"),
                getString(toConvert, "rate_id"),
                getString(toConvert, "label"),
                toConvert.getBoolean("compound"),
                getString(toConvert, "tax_total"),
                getString(toConvert, "shipping_tax_total")
        );
    }

    public static OrderShipping jsonToOrderShipping(JSONObject toConvert) throws JSONException {
        return new OrderShipping(
                getString(toConvert, "first_name"),
                getString(toConvert, "last_name"),
                getString(toConvert, "company"),
                getString(toConvert, "address_1"),
                getString(toConvert, "address_2"),
                getString(toConvert, "city"),
                getString(toConvert, "state"),
                getString(toConvert, "postcode"),
                getString(toConvert, "country")
        );
    }

    public static OrderBilling jsonToOrderBilling(JSONObject toConvert) throws JSONException {
        return new OrderBilling(
                getString(toConvert, "first_name"),
                getString(toConvert, "last_name"),
                getString(toConvert, "company"),
                getString(toConvert, "address_1"),
                getString(toConvert, "address_2"),
                getString(toConvert, "city"),
                getString(toConvert, "state"),
                getString(toConvert, "postcode"),
                getString(toConvert, "country"),
                getString(toConvert, "email"),
                getString(toConvert, "phone")
        );
    }

    public static OrderStatus jsonToOrderStatus(JSONObject toConvert) throws JSONException {
        switch (getString(toConvert, "status")) {
            case "processing":
                return OrderStatus.PROCESSING;

            case "on-hold":
                return OrderStatus.ONHOLD;

            case "completed":
                return OrderStatus.COMPLETED;

            case "cancelled":
                return OrderStatus.CANCELLED;

            case "refunded":
                return OrderStatus.REFUNDED;

            case "failed":
                return OrderStatus.FAILED;

            case "trash":
                return OrderStatus.TRASH;

            default:
                return OrderStatus.PENDING;
        }
    }
}
