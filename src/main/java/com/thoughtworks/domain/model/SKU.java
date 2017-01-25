package com.thoughtworks.domain.model;

import java.util.Date;

//Entity
public class SKU {
    private String id;
    private Date expirtyDate;

    public SKU(String id, Date expirtyDate) {
        this.id = id;
        this.expirtyDate = expirtyDate;
    }

    public String getId() {
        return id;
    }

    public Date getExpirtyDate() {
        return expirtyDate;
    }
}
