package com.thoughtworks.domain.event;

import com.thoughtworks.domain.model.Item;

import java.util.List;

public class CartCheckoutEvent {
    private String cartId;

    private List<Item> items;

    public CartCheckoutEvent(String id, List<Item> items) {
        this.cartId = id;
        this.items = items;
    }


    public List<Item> getItems() {
        return items;
    }

    public String getId() {
        return cartId;
    }
}
