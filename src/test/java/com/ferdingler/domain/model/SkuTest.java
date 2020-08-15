package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class SkuTest {

    @Test
    public void skuMustNotBeNull() {
        assertThrows(RuntimeException.class, () -> {
            new Sku(null);
        });
    }

    @Test
    public void skuMustNotBeEmpty() {
        assertThrows(RuntimeException.class, () -> {
            new Sku("");
        });
    }

    @Test
    public void skuMustNotBeBlank() {
        assertThrows(RuntimeException.class, () -> {
            new Sku("   ");
        });
    }

    @Test
    public void skuHasValidFormat() {
        Sku sku = new Sku("123");
        assertEquals("123", sku.getValue());
    }

    @Test
    public void twoSkusWithSameValueAreEqual() {
        Sku one = new Sku("123");
        Sku two = new Sku("123");
        assertEquals(one, two);
    }
}