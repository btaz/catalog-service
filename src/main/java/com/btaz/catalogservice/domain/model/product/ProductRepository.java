package com.btaz.catalogservice.domain.model.product;

import java.math.BigDecimal;

public interface ProductRepository {
    /**
     * Store a product entity
     * @param productId product Id
     * @param catalogId catalog Id
     * @param name product name
     * @param description product description
     * @param price product price
     * @return product Id
     */
    String create(String productId, String catalogId, String name, String description, BigDecimal price);

    /**
     * Update an existing product
     * @param id product Id
     * @param name product name
     * @param description product description
     * @param price product price
     */
    void update(String id, String name, String description, BigDecimal price);

    /**
     * Find product by Id
     * @param id Id
     * @return Product entity
     */
    Product find(String id);

    /**
     * Delete product by Id
     * @param id Id
     */
    void delete(String id);

    /**
     * Get the count of products
     * @return number of products
     */
    int size();

    /**
     * Generate a unique generated tracking Id
     * @return a unique Id
     */
    String nextProductId();
}
