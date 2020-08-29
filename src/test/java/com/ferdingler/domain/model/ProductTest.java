package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductTest {

    private Product product;

    @Inject
    private ProductFactory productFactory;

    @BeforeEach
    void setUp() {
        this.product = productFactory.buildNewProduct("Banana", "Electronics", 50);
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
    public void newProductHasCategory() {
        Category category = this.product.getCategory();
        assertEquals("Electronics", category.getName());
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