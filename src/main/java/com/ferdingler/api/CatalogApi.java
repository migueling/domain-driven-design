package com.ferdingler.api;

import com.ferdingler.application.CatalogApplication;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

@Controller("/catalog")
public class CatalogApi {

    @Inject
    private CatalogApplication catalog;

    @Get("/products")
    public List<ProductInfo> listProducts() {
        return catalog.listProducts();
    }

    @Post("/product")
    public void createProduct(CreateProductRequest request) {
        catalog.createProduct(request);
    }

}
