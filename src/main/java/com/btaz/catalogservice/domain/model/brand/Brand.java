package com.btaz.catalogservice.domain.model.brand;

public final class Brand {
    private final String brandId;
    private final String catalogId;
    private final String name;
    private final String description;

    public Brand(String brandId, String catalogId, String name, String description) {
        this.brandId = brandId;
        this.catalogId = catalogId;
        this.name = name;
        this.description = description;
    }

    public String brandId() {
        return brandId;
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
}
