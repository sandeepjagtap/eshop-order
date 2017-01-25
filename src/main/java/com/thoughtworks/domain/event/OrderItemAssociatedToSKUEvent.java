package com.thoughtworks.domain.event;

import com.thoughtworks.domain.model.SKU;

import java.util.List;

public class OrderItemAssociatedToSKUEvent {
    private String orderId;
    private final String itemId;
    private final List<SKU> skus;

    public OrderItemAssociatedToSKUEvent(String id, String itemId, List<SKU> skus) {
        this.orderId = id;
        this.itemId = itemId;
        this.skus = skus;
    }

    public String getItemId() {
        return itemId;
    }

    public List<SKU> getSkus() {
        return skus;
    }

    public String getOrderId() {
        return orderId;
    }
}
