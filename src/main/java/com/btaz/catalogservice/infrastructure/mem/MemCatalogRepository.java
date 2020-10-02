package com.btaz.catalogservice.infrastructure.mem;

import com.btaz.catalogservice.domain.model.catalog.Catalog;
import com.btaz.catalogservice.domain.model.catalog.CatalogRepository;
import org.bson.types.ObjectId;

import java.util.concurrent.ConcurrentHashMap;

public class MemCatalogRepository implements CatalogRepository {
    private final ConcurrentHashMap<String,Catalog> dataStore;

    public MemCatalogRepository() {
        dataStore = new ConcurrentHashMap<>();
    }

    @Override
    public String create(String id, String name, String description) {
        dataStore.put(id, new Catalog(id, name, description));
        return id;
    }

    @Override
    public void update(String id, String name, String description) {
        if(dataStore.containsKey(id)) {
            dataStore.put(id, new Catalog(id, name, description));
        }
    }

    @Override
    public Catalog find(String id) {
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
    public String nextCatalogId() {
        return new ObjectId().toHexString();
    }
}
