package com.btaz.catalogservice.domain.model;

public class Catalog {
    private final String id;
    private final String name;
    private final String description;

    public Catalog(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
