package com.btaz.catalogservice.infrastructure.mem;

import com.btaz.catalogservice.domain.model.product.Product;
import com.btaz.catalogservice.domain.model.product.ProductRepository;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class MemProductRepository implements ProductRepository {
    private final ConcurrentHashMap<String, Product> dataStore;

    public MemProductRepository() {
        dataStore = new ConcurrentHashMap<>();
    }

    @Override
    public String create(String productId, String catalogId, String name, String description, BigDecimal price) {
        dataStore.put(productId, new Product(productId, catalogId, name, description, price));
        return productId;
    }

    @Override
    public void update(String id, String name, String description, BigDecimal price) {
        Product product = dataStore.get(id);
        if(product != null) {
            dataStore.put(id, new Product(id, product.catalogId(), name, description, price));
        }
    }

    @Override
    public Product find(String id) {
        return dataStore.get(id);
    }

    @Override
    public void delete(String id) {
        dataStore.remove(id);
    }

    @Override
    public int size() {
        return dataStore.size();
    }

    @Override
    public String nextProductId() {
        return new ObjectId().toHexString();
    }
}
