package com.btaz.catalogservice.domain.model.product;

import java.math.BigDecimal;

public final class Product {
    private final String productId;
    private final String catalogId;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public Product(String productId, String catalogId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.catalogId = catalogId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String productId() {
        return productId;
    }

    public String catalogId() {
        return catalogId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public BigDecimal price() {
        return price;
    }
}
