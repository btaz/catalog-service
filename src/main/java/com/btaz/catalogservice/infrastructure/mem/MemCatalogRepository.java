package com.btaz.catalogservice.infrastructure.mem;

import com.btaz.catalogservice.domain.model.Catalog;
import com.btaz.catalogservice.domain.model.CatalogRepository;
import org.bson.types.ObjectId;

import java.util.concurrent.ConcurrentHashMap;

public class MemCatalogRepository implements CatalogRepository {
    private final ConcurrentHashMap<String,Catalog> dataStore;

    public MemCatalogRepository() {
        dataStore = new ConcurrentHashMap<>();
    }

    @Override
    public Catalog create(Catalog catalog) {
        dataStore.put(catalog.id(), catalog);
        return catalog;
    }

    @Override
    public void update(Catalog updatedCatalog) {
        Catalog existingCatalog = dataStore.get(updatedCatalog.id());
        dataStore.put(updatedCatalog.id(), updatedCatalog);
    }

    @Override
    public Catalog find(String id) {
        return dataStore.get(id);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public String nextCatalogId() {
        return new ObjectId().toHexString();
    }
}
