package com.btaz.catalogservice.domain.model.category;

public interface CategoryRepository {
    /**
     * Store a category entity
     * @param categoryId category Id
     * @param catalogId catalog Id
     * @param name category name
     * @param description category description
     * @return category Id
     */
    String create(String categoryId, String catalogId, String name, String description);

    /**
     * Update an existing category
     * @param id category Id
     * @param name category name
     * @param description category description
     */
    void update(String id, String name, String description);

    /**
     * Find category by Id
     * @param id Id
     * @return category entity
     */
    Category find(String id);

    /**
     * Delete category by Id
     * @param id Id
     */
    void delete(String id);

    /**
     * Get the count of categories
     * @return number of categories
     */
    int size();

    /**
     * Generate a unique generated tracking Id
     * @return a unique Id
     */
    String nextCategoryId();
}
