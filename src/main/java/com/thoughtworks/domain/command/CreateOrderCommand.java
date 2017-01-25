package com.thoughtworks.domain.command;

import com.thoughtworks.domain.model.Item;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.List;

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    private final String cartId;
    private final List<Item> items;

    public CreateOrderCommand(String orderId, String cartId, List<Item> items) {

        this.orderId = orderId;
        this.cartId = cartId;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCartId() {
        return cartId;
    }

    public List<Item> getItems() {
        return items;
    }
}
