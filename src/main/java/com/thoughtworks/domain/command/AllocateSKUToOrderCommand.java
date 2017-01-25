package com.thoughtworks.domain.command;

import com.thoughtworks.domain.model.SKU;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.List;

public class AllocateSKUToOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;

    private final String itemId;
    private final List<SKU> skus;

    public AllocateSKUToOrderCommand(String itemId, List<SKU> skus, String orderId) {
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
}
