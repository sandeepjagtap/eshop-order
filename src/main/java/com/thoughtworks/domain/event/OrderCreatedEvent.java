package com.thoughtworks.domain.event;

import com.thoughtworks.domain.model.Item;

import java.util.List;

public class OrderCreatedEvent {
    private String id;
    private List<Item> items;

    public OrderCreatedEvent(String id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }
}
