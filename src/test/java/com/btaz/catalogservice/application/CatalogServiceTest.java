package com.btaz.catalogservice.application;

import com.btaz.catalogservice.domain.model.Catalog;
import com.btaz.catalogservice.domain.model.CatalogRepository;
import com.btaz.catalogservice.infrastructure.mem.MemCatalogRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogServiceTest {
    private CatalogService service;

    @BeforeMethod
    public void beforeMethod() {
        service = new CatalogService(new MemCatalogRepository());
    }

    @Test
    public void testAddAndFindCatalogShouldBeSuccessful() {
        // given
        String name = "tools";
        String description = "miscellaneous tools";

        // when
        Catalog createdCatalog = service.addCatalog(name, description);
        Catalog foundCatalog = service.find(createdCatalog.id());

        // then
        assertThat(createdCatalog).isEqualTo(foundCatalog);
        assertThat(createdCatalog.name()).isEqualTo(foundCatalog.name());
        assertThat(createdCatalog.description()).isEqualTo(foundCatalog.description());
    }

    public void testDeleteOfCatalogShouldBeSuccessful() {
        // given
        String name = "tools";
        String description = "miscellaneous tools";

        // when
        Catalog createdCatalog = service.addCatalog(name, description);
        service.deleteCatalog(createdCatalog.id());
        Catalog foundCatalog = service.find(createdCatalog.id());

        // then
        assertThat(foundCatalog).isNull();
    }
}
