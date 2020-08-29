package com.ferdingler.application;

import com.ferdingler.api.ProductInfo;
import com.ferdingler.domain.model.*;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ProductInfoMapperTest {

    private Product product;
    private ProductInfo productInfo;

    @Inject
    ProductFactory productFactory;

    @BeforeEach
    void setUp() {
        this.product = productFactory.buildNewProduct("Banana", "Books", 100);
        this.productInfo = ProductInfoMapper.map(product);
    }

    @Test
    public void mapsProductName() {
        assertEquals("Banana", productInfo.getProductName());
    }

    @Test
    public void mapsProductSku() {
        Sku sku = this.product.getSku();
        assertEquals(sku.getValue(), productInfo.getSku());
    }

    @Test
    public void mapsProductCategory() {
        assertEquals("Books", productInfo.getCategory());
    }

    @Test
    public void mapsProductPrice() {
        assertEquals(100, productInfo.getPrice());
    }

}