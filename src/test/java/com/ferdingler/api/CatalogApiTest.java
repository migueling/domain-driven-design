package com.ferdingler.api;

import com.ferdingler.application.CatalogApplication;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MicronautTest
class CatalogApiTest {

    @Inject
    CatalogApi catalogApi;

    @Inject
    CatalogApplication catalogApplication;

    @MockBean(CatalogApplication.class)
    CatalogApplication catalogApplication() {
        return mock(CatalogApplication.class);
    }

    @Test
    public void listProductsReturnsListFromCatalogApplication() {
        List<ProductInfo> productList = new ArrayList<>();
        when(catalogApplication.listProducts()).thenReturn(productList);

        List<ProductInfo> response = catalogApi.listProducts();
        verify(catalogApplication).listProducts();
        assertSame(productList, response);
    }

    @Test
    public void createProductCallsCatalogApplicationWithRequest() {
        CreateProductRequest request = new CreateProductRequest();
        request.setProductName("Banana");

        catalogApi.createProduct(request);
        verify(catalogApplication).createProduct(request);
    }

}