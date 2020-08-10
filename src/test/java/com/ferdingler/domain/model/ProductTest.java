package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        this.product = Product.buildNewProduct("Banana");
    }

    @Test
    public void newProductHasName() {
        assertEquals("Banana", this.product.getName());
    }

    @Test
    public void newProductHasSku() {
        Sku sku = this.product.getSku();
        assertFalse(sku.getValue().isBlank());
    }

    @Test
    public void nameCannotBeBlank() {
        assertThrows(RuntimeException.class, () -> {
            this.product.setName("");
        });
    }

    @Test
    public void nameCannotBeNull() {
        assertThrows(RuntimeException.class, () -> {
            this.product.setName(null);
        });
    }

}