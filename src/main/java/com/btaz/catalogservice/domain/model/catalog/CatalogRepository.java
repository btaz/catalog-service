package com.btaz.catalogservice.domain.model.catalog;

public interface CatalogRepository {
    /**
     * Store a catalog entity
     * @param id catalog Id
     * @param name catalog name
     * @param description catalog description
     * @return catalog Id
     */
    String create(String id, String name, String description);

    /**
     * Update an existing catalog
     * @param id catalog Id
     * @param name catalog name
     * @param description catalog description
     */
    void update(String id, String name, String description);

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
     * Get the count of catalogs
     * @return number of catalogs
     */
    int size();

    /**
     * Generate a unique generated tracking Id
     * @return a unique Id
     */
    String nextCatalogId();
}
