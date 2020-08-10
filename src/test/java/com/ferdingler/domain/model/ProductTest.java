package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductTest {

    @Test
    public void newProductHasName() {
        Product product = Product.buildNewProduct("Banana");
        assertEquals("Banana", product.getName());
    }

    @Test
    public void newProductHasSku() {
        Product product = Product.buildNewProduct("Banana");
        Sku sku = product.getSku();
        assertFalse(sku.getValue().isBlank());
    }

}