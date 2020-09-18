package com.btaz.catalogservice.application;

import com.btaz.catalogservice.domain.model.Catalog;
import com.btaz.catalogservice.domain.model.CatalogRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CatalogServiceTest {
    private CatalogService service;

    @Mock
    private CatalogRepository catalogRepository;

    @BeforeMethod
    public void beforeMethod() {
        MockitoAnnotations.openMocks(this);
        service = new CatalogService(catalogRepository);
    }

    @Test
    public void testAddCatalogShouldBeSuccessful() {
        // given
        doNothing().when(catalogRepository).store(any(Catalog.class));
        String name = "tools";
        String description = "miscellaneous tools";

        // when
        service.addCatalog(name, description);

        // then
        verify(catalogRepository, atLeastOnce()).store(any(Catalog.class));
    }
}