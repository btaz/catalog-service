package com.btaz.catalogservice.domain.model.category;

public final class Category {
    private final String categoryId;
    private final String catalogId;
    private final String name;
    private final String description;

    public Category(String categoryId, String catalogId, String name, String description) {
        this.categoryId = categoryId;
        this.catalogId = catalogId;
        this.name = name;
        this.description = description;
    }

    public String categoryId() {
        return categoryId;
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
