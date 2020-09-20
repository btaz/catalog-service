package com.btaz.catalogservice.domain.model;

public interface CatalogRepository {
    /**
     * Store catalog entities
     * @param catalog catalog
     * @return catalog
     */
    Catalog create(Catalog catalog);

    /**
     * Update an existing catalog
     * @param catalog catalog
     */
    void update(Catalog catalog);

    /**
     * Find catalog by Id
     * @param id Id
     * @return Catalog entity
     */
    Catalog find(String id);

    /**
     * Delete catalog by Id
     * @param id Id
     */
    void delete(String id);

    /**
     * Generate a unique generated tracking Id
     * @return a unique Id
     */
    String nextCatalogId();
}
