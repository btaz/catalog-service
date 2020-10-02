package com.btaz.catalogservice.application;

import com.btaz.catalogservice.domain.model.brand.Brand;
import com.btaz.catalogservice.domain.model.brand.BrandRepository;
import com.btaz.catalogservice.domain.model.catalog.Catalog;
import com.btaz.catalogservice.domain.model.catalog.CatalogRepository;
import com.btaz.catalogservice.domain.model.category.Category;
import com.btaz.catalogservice.domain.model.category.CategoryRepository;
import com.btaz.catalogservice.domain.model.product.Product;
import com.btaz.catalogservice.domain.model.product.ProductRepository;

import java.math.BigDecimal;

public final class CatalogService {
    private final CatalogRepository catalogRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CatalogService(CatalogRepository catalogRepository,
                          BrandRepository brandRepository,
                          CategoryRepository categoryRepository,
                          ProductRepository productRepository) {
        this.catalogRepository = catalogRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    /**
     * Add a new catalog
     * @param name catalog name
     * @param description catalog description
     * @return catalog
     */
    public String addCatalog(String name, String description) {
        return catalogRepository.create(catalogRepository.nextCatalogId(), name, description);
    }

    /**
     * Find catalog by Id
     * @param catalogId catalog Id
     * @return catalog
     */
    public Catalog findCatalog(String catalogId) {
        return catalogRepository.find(catalogId);
    }

    /**
     * Update catalog
     * @param id catalog Id
     * @param name catalog name
     * @param description catalog description
     */
    public void updateCatalog(String id, String name, String description) {
        catalogRepository.update(id, name, description);
    }

    /**
     * Delete catalog
     * @param id catalog Id
     */
    public void deleteCatalog(String id) {
        catalogRepository.delete(id);
    }

    /**
     * Number of catalogs
     * @return catalog count
     */
    public int catalogCount() {
        return catalogRepository.size();
    }

    /**
     * Add a new brand
     * @param catalogId catalog Id
     * @param name brand name
     * @param description brand description
     * @return brand Id
     */
    public String addBrand(String catalogId, String name, String description) {
        return brandRepository.create(brandRepository.nextBrandId(), catalogId, name, description);
    }

    /**
     * Find brand by Id
     * @param brandId brand Id
     * @return brand
     */
    public Brand findBrand(String brandId) {
        return brandRepository.find(brandId);
    }

    /**
     * Update brand
     * @param brandId brand Id
     * @param name brand name
     * @param description brand description
     */
    public void updateBrand(String brandId, String name, String description) {
        brandRepository.update(brandId, name, description);
    }

    /**
     * Delete brand
     * @param id brand Id
     */
    public void deleteBrand(String id) {
        brandRepository.delete(id);
    }

    /**
     * Number of brands
     * @return brand count
     */
    public int brandCount() {
        return brandRepository.size();
    }

    /**
     * Add a new category
     * @param catalogId catalog Id
     * @param name category name
     * @param description category description
     * @return category Id
     */
    public String addCategory(String catalogId, String name, String description) {
        return categoryRepository.create(categoryRepository.nextCategoryId(), catalogId, name, description);
    }

    /**
     * Find category by Id
     * @param categoryId category Id
     * @return category
     */
    public Category findCategory(String categoryId) {
        return categoryRepository.find(categoryId);
    }

    /**
     * Update category
     * @param categoryId category Id
     * @param name category name
     * @param description category description
     */
    public void updateCategory(String categoryId, String name, String description) {
        categoryRepository.update(categoryId, name, description);
    }

    /**
     * Delete category
     * @param id category Id
     */
    public void deleteCategory(String id) {
        categoryRepository.delete(id);
    }

    /**
     * Number of categories
     * @return category count
     */
    public int categoryCount() {
        return categoryRepository.size();
    }

    /**
     * Add product
     * @param catalogId catalog Id
     * @param name product name
     * @param description product description
     * @param price product price
     * @return id product Id
     */
    public String addProduct(String catalogId, String name, String description, BigDecimal price) {
        return productRepository.create(productRepository.nextProductId(), catalogId, name, description, price);
    }

    /**
     * Find product by Id
     * @param productId product Id
     * @return product
     */
    public Product findProduct(String productId) {
        return productRepository.find(productId);
    }

    /**
     * Update product
     * @param productId product Id
     * @param name product name
     * @param description product description
     * @param price product price
     */
    public void updateProduct(String productId, String name, String description, BigDecimal price) {
        productRepository.update(productId, name, description, price);
    }

    /**
     * Delete product
     * @param productId product Id
     */
    public void deleteProduct(String productId) {
        productRepository.delete(productId);
    }

    /**
     * Number of products
     * @return product count
     */
    public int productCount() {
        return productRepository.size();
    }
}
