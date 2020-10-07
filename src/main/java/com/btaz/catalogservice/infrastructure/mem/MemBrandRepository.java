package com.btaz.catalogservice.infrastructure.mem;

import com.btaz.catalogservice.domain.model.brand.Brand;
import com.btaz.catalogservice.domain.model.brand.BrandRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Component
public final class MemBrandRepository implements BrandRepository {
    private final ConcurrentHashMap<String, Brand> dataStore;

    public MemBrandRepository() {
        dataStore = new ConcurrentHashMap<>();
    }

    @Override
    public String create(String brandId, String catalogId, String name, String description) {
        dataStore.put(brandId, new Brand(brandId, catalogId, name, description));
        return brandId;
    }

    @Override
    public void update(String id, String name, String description) {
        Brand brand = dataStore.get(id);
        if(brand != null) {
            dataStore.put(id, new Brand(id, brand.catalogId(), name, description));
        }
    }

    @Override
    public Brand find(String id) {
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
    public String nextBrandId() {
        return new ObjectId().toHexString();
    }
}
