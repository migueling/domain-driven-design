package com.ferdingler.domain.model;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CategoryTest {

    @Test
    public void categoryMustNotBeNull() {
        assertThrows(RuntimeException.class, () -> {
            new Category(null);
        });
    }

    @Test
    public void categoryMustNotBeEmpty() {
        assertThrows(RuntimeException.class, () -> {
            new Category("");
        });
    }

    @Test
    public void categoryMustNotBeBlank() {
        assertThrows(RuntimeException.class, () -> {
            new Category("   ");
        });
    }

    @Test
    public void categoryHasValidFormat() {
        Category category = new Category("Electronics");
        assertEquals("Electronics", category.getName());
    }

    @Test
    public void twoCategoriesWithSameNameAreEqual() {
        Category one = new Category("Electronics");
        Category two = new Category("Electronics");
        assertEquals(one, two);
    }

}