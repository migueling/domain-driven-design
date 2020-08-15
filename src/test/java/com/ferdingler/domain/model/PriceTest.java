package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class PriceTest {

    @Test
    public void priceCannotBeLessThanZero() {
        assertThrows(RuntimeException.class, () -> {
            new Price(-1);
        });
    }

    @Test
    public void priceCanBeZero() {
        Price price = new Price(0);
        assertEquals(0, price.getValue());
    }

    @Test
    public void priceCanBeGreaterThanZero() {
        Price price = new Price(1000);
        assertEquals(1000, price.getValue());
    }
}