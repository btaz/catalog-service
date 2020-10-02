package com.btaz.catalogservice.domain.model.brand;

public interface BrandRepository {
    /**
     * Store a brand entity
     * @param brandId brand Id
     * @param catalogId catalog Id
     * @param name brand name
     * @param description brand description
     * @return brand Id
     */
    String create(String brandId, String catalogId, String name, String description);

    /**
     * Update an existing brand
     * @param id brand Id
     * @param name brand name
     * @param description brand description
     */
    void update(String id, String name, String description);

    /**
     * Find brand by Id
     * @param id Id
     * @return Brand entity
     */
    Brand find(String id);

    /**
     * Delete brand by Id
     * @param id Id
     */
    void delete(String id);

    /**
     * Get the count of brands
     * @return number of brands
     */
    int size();

    /**
     * Generate a unique generated tracking Id
     * @return a unique Id
     */
    String nextBrandId();
}
