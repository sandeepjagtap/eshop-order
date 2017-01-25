package com.thoughtworks.domain.event;

import com.thoughtworks.domain.model.SKU;

import java.util.List;

public class SKUAllocatedToOrderItemEvent {

    private final String itemId;
    private final List<SKU> skus;
    private String orderId;

    public SKUAllocatedToOrderItemEvent(String itemId, List<SKU> skus, String orderId) {
        this.itemId = itemId;
        this.skus = skus;
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "SKUAllocatedToOrderItemEvent{" +
                "itemId='" + itemId + '\'' +
                ", skus=" + skus +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
