package com.thoughtworks.domain.model;

import java.util.List;

//Entity
public class Item {

    private String identifier;
    private int quantity;
    private List<SKU> skus;


    public Item(String identifier, int quantity) {
        this.identifier = identifier;
        this.quantity = quantity;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void associateSKUs(List<SKU> skus) {
        this.skus = skus;
    }
}
