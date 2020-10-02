package com.btaz.catalogservice.application;

import com.btaz.catalogservice.domain.model.brand.Brand;
import com.btaz.catalogservice.domain.model.catalog.Catalog;
import com.btaz.catalogservice.domain.model.category.Category;
import com.btaz.catalogservice.domain.model.product.Product;
import com.btaz.catalogservice.infrastructure.mem.MemBrandRepository;
import com.btaz.catalogservice.infrastructure.mem.MemCatalogRepository;
import com.btaz.catalogservice.infrastructure.mem.MemCategoryRepository;
import com.btaz.catalogservice.infrastructure.mem.MemProductRepository;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogServiceTest {
    private CatalogService service;

    @BeforeMethod
    public void beforeMethod() {
        service = new CatalogService(
                new MemCatalogRepository(),
                new MemBrandRepository(),
                new MemCategoryRepository(),
                new MemProductRepository()
        );
    }

    @Test
    public void testAddAndFindCatalogShouldBeSuccessful() {
        // given
        String name = "tools";
        String description = "miscellaneous tools";

        // when
        String catalogId = service.addCatalog(name, description);
        Catalog catalog = service.findCatalog(catalogId);

        // then
        assertThat(catalog).isNotNull();
        assertThat(catalog.name()).isEqualTo(name);
        assertThat(catalog.description()).isEqualTo(description);
    }

    @Test
    public void testUpdateOfCatalogShouldBeSuccessful() {
        // given
        String name = "tools";
        String description = "miscellaneous tools";
        String changedName = "metal tools";
        String changedDescription = "tools used to work with metal";

        // when
        String catalogId = service.addCatalog(name, description);
        Catalog catalog = service.findCatalog(catalogId);

        // then
        assertThat(catalog).isNotNull();
        assertThat(catalog.name()).isEqualTo(name);
        assertThat(catalog.description()).isEqualTo(description);

        // when
        service.updateCatalog(catalogId, changedName, changedDescription);
        Catalog changedCatalog = service.findCatalog(catalogId);

        // then
        assertThat(changedCatalog).isNotNull();
        assertThat(changedCatalog.name()).isEqualTo(changedName);
        assertThat(changedCatalog.description()).isEqualTo(changedDescription);
    }

    @Test
    public void testDeleteOfCatalogShouldBeSuccessful() {
        // given
        String name = "tools";
        String description = "miscellaneous tools";

        // when
        String catalogId = service.addCatalog(name, description);

        // then
        assertThat(service.catalogCount()).isEqualTo(1);

        // when
        service.deleteCatalog(catalogId);
        Catalog catalog = service.findCatalog(catalogId);

        // then
        assertThat(service.catalogCount()).isEqualTo(0);
        assertThat(catalog).isNull();
    }

    @Test
    public void testAddAndFindBrandShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String name = "brand-name";
        String description = "brand-description";

        // when
        String brandId = service.addBrand(catalogId, name, description);
        Brand brand = service.findBrand(brandId);

        // then
        assertThat(brand).isNotNull();
        assertThat(brand.catalogId()).isEqualTo(catalogId);
        assertThat(brand.name()).isEqualTo(name);
        assertThat(brand.description()).isEqualTo(description);
    }

    @Test
    public void testUpdateOfBrandShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String originalName = "original-name";
        String originalDescription = "original-description";
        String updatedName = "updated-name";
        String updatedDescription = "updated-description";

        // when
        String brandId = service.addBrand(catalogId, originalName, originalDescription);
        service.updateBrand(brandId, updatedName, updatedDescription);
        Brand brand = service.findBrand(brandId);

        // then
        assertThat(brand).isNotNull();
        assertThat(brand.brandId()).isEqualTo(brandId);
        assertThat(brand.catalogId()).isEqualTo(catalogId);
        assertThat(brand.name()).isEqualTo(updatedName);
        assertThat(brand.description()).isEqualTo(updatedDescription);
    }

    @Test
    public void testDeleteOfBrandShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String name = "brand-name";
        String description = "brand-description";

        // when
        String brandId = service.addBrand(catalogId, name, description);

        // then
        assertThat(service.brandCount()).isEqualTo(1);

        // when
        service.deleteBrand(brandId);
        Brand brand = service.findBrand(brandId);

        // then
        assertThat(brand).isNull();
        assertThat(service.brandCount()).isEqualTo(0);
    }

    @Test
    public void testAddAndFindCategoryShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String name = "category-name";
        String description = "category-description";

        // when
        String categoryId = service.addCategory(catalogId, name, description);
        Category category = service.findCategory(categoryId);

        // then
        assertThat(category).isNotNull();
        assertThat(category.catalogId()).isEqualTo(catalogId);
        assertThat(category.name()).isEqualTo(name);
        assertThat(category.description()).isEqualTo(description);
    }

    @Test
    public void testUpdateOfCategoryShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String originalName = "original-name";
        String originalDescription = "original-description";
        String updatedName = "updated-name";
        String updatedDescription = "updated-description";

        // when
        String categoryId = service.addCategory(catalogId, originalName, originalDescription);
        service.updateCategory(categoryId, updatedName, updatedDescription);
        Category category = service.findCategory(categoryId);

        // then
        assertThat(category).isNotNull();
        assertThat(category.categoryId()).isEqualTo(categoryId);
        assertThat(category.catalogId()).isEqualTo(catalogId);
        assertThat(category.name()).isEqualTo(updatedName);
        assertThat(category.description()).isEqualTo(updatedDescription);
    }

    @Test
    public void testDeleteOfCategoryShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String name = "category-name";
        String description = "category-description";

        // when
        String categoryId = service.addCategory(catalogId, name, description);

        // then
        assertThat(service.categoryCount()).isEqualTo(1);

        // when
        service.deleteCategory(categoryId);
        Category category = service.findCategory(categoryId);

        // then
        assertThat(category).isNull();
        assertThat(service.categoryCount()).isEqualTo(0);
    }

    @Test
    public void testAddAndFindProductShouldBeSuccessful() {
        // given
        String catalogId = "product-id";
        String name = "product-name";
        String description = "product-description";
        BigDecimal price = new BigDecimal("12.34");

        // when
        String productId = service.addProduct(catalogId, name, description, price);
        Product product = service.findProduct(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(product.productId()).isEqualTo(productId);
        assertThat(product.name()).isEqualTo(name);
        assertThat(product.description()).isEqualTo(description);
        assertThat(product.price()).isEqualTo(price);
    }

    @Test
    public void testUpdateOfProductShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String originalName = "original-name";
        String originalDescription = "original-description";
        BigDecimal originalPrice = new BigDecimal("123.45");
        String updatedName = "updated-name";
        String updatedDescription = "updated-description";
        BigDecimal updatedPrice = new BigDecimal("456.78");

        // when
        String productId = service.addProduct(catalogId, originalName, originalDescription, originalPrice);
        service.updateProduct(productId, updatedName, updatedDescription, updatedPrice);
        Product product = service.findProduct(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(product.productId()).isEqualTo(productId);
        assertThat(product.catalogId()).isEqualTo(catalogId);
        assertThat(product.name()).isEqualTo(updatedName);
        assertThat(product.description()).isEqualTo(updatedDescription);
        assertThat(product.price()).isEqualTo(updatedPrice);
    }

    @Test
    public void testDeleteOfProductShouldBeSuccessful() {
        // given
        String catalogId = "catalog-id";
        String name = "product-name";
        String description = "product-description";
        BigDecimal price = new BigDecimal("123.45");

        // when
        String productId = service.addProduct(catalogId, name, description, price);

        // then
        assertThat(service.productCount()).isEqualTo(1);

        // when
        service.deleteProduct(productId);
        Product product = service.findProduct(productId);

        // then
        assertThat(product).isNull();
        assertThat(service.productCount()).isEqualTo(0);
    }
}
