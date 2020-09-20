package com.btaz.catalogservice.application;

import com.btaz.catalogservice.domain.model.Catalog;
import com.btaz.catalogservice.domain.model.CatalogRepository;

public final class CatalogService {
    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    /**
     * Add a new catalog
     * @param name catalog name
     * @param description catalog description
     * @return catalog
     */
    public Catalog addCatalog(String name, String description) {
        return catalogRepository.create(new Catalog(catalogRepository.nextCatalogId(), name, description));
    }

    /**
     * Update catalog
     */
    public void updateCatalog(Catalog catalog) {
        catalogRepository.update(catalog);
    }

    public void deleteCatalog(String id) {
        catalogRepository.delete(id);
    }

    /**
     * Find catalog
     * @param id Id
     * @return catalog
     */
    public Catalog find(String id) {
        return catalogRepository.find(id);
    }

    /**
     * Add a new brand
     * @param catalogId catalog Id
     */
    public void addBrand(String catalogId) {

    }

    /**
     * Update brand
     * @param brandName brand name
     */
    public void updateBrand(String brandName) {

    }

    /**
     * Add a new category
     * @param catalogId catalog Id
     * @param categoryName category name
     */
    public void addCategory(String catalogId, String categoryName) {

    }

    /**
     * Update category
     * @param categoryId category Id
     * @param categoryName category name
     */
    public void updateCategory(String categoryId, String categoryName) {

    }

    /**
     * Add product
     * @param catalogId catalog Id
     * @param productName product name
     */
    public void addProduct(String catalogId, String productName) {

    }

    /**
     * Update product
     * @param productId product Id
     */
    public void updateProduct(String productId) {

    }

    /**
     * Remove product
     * @param productId product Id
     */
    public void removeProduct(String productId) {

    }
}
