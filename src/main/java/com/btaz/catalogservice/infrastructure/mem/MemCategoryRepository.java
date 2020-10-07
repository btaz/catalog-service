package com.btaz.catalogservice.infrastructure.mem;

import com.btaz.catalogservice.domain.model.brand.Brand;
import com.btaz.catalogservice.domain.model.category.Category;
import com.btaz.catalogservice.domain.model.category.CategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemCategoryRepository implements CategoryRepository {
    private final ConcurrentHashMap<String, Category> dataStore;

    public MemCategoryRepository() {
        dataStore = new ConcurrentHashMap<>();
    }

    @Override
    public String create(String categoryId, String catalogId, String name, String description) {
        dataStore.put(categoryId, new Category(categoryId, catalogId, name, description));
        return categoryId;
    }

    @Override
    public void update(String id, String name, String description) {
        Category category = dataStore.get(id);
        if(category != null) {
            dataStore.put(id, new Category(id, category.catalogId(), name, description));
        }
    }

    @Override
    public Category find(String id) {
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
    public String nextCategoryId() {
        return new ObjectId().toHexString();
    }
}
