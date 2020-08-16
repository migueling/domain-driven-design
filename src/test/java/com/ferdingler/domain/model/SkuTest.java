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

    /**
     * Lab - Part 2 Solution
     */
    @Test
    void generatedSkuStartsWithFirst4LettersOfCategory() {
        Category category = new Category("Electronics");
        Sku sku = Sku.generate(category, "Tablet");
        assertTrue(sku.getValue().startsWith("ELEC"));
    }

    @Test
    void generatedSkuContainsFirst10LettersOfProductName() {
        Category category = new Category("Electronics");
        Sku sku = Sku.generate(category, "Apple Tablet");
        assertTrue(sku.getValue().contains("-APPLETABLE"));
    }

    @Test
    void generatedSkuEndsWith5RandomDigits() {
        Category category = new Category("Electronics");
        Sku sku = Sku.generate(category, "Apple Tablet");
        String skuStr = sku.getValue();
        assertTrue(skuStr.matches("ELEC-APPLETABLE-\\d{5}"));
    }

    @Test
    void generatedSkuWhenProductNameHasLessThan10Chars() {
        Category category = new Category("Electronics");
        Sku sku = Sku.generate(category, "Phone");
        assertTrue(sku.getValue().contains("-PHONE-"));
    }

    @Test
    void generateSkuThrowsExceptionWhenProductNameIsNull() {
        assertThrows(RuntimeException.class, () -> {
            Category category = new Category("Electronics");
            Sku.generate(category, null);
        });
    }

    @Test
    void generatedSkuWhenCategoryHasLessThan4Chars() {
        Category category = new Category("abc");
        Sku sku = Sku.generate(category, "Phone");
        assertTrue(sku.getValue().startsWith("ABC-"));
    }

    @Test
    void generatedSkuWhenProductNameIsEmpty() {
        Category category = new Category("abc");
        Sku sku = Sku.generate(category, "");
        assertTrue(sku.getValue().startsWith("ABC--"));
    }

    @Test
    void generatedSkuWhenProductNameIsBlank() {
        Category category = new Category("abc");
        Sku sku = Sku.generate(category, "     ");
        assertTrue(sku.getValue().startsWith("ABC--"));
    }

    @Test
    void twoGeneratedSkusEndWithDifferentRandomNumbers() {
        Category category = new Category("Electronics");
        String productName = "Tablet";

        Sku skuOne = Sku.generate(category, productName);
        Sku skuTwo = Sku.generate(category, productName);

        assertNotEquals(skuOne, skuTwo);
    }

    @Test
    void generatedSkuRemovesSpacesFromCategory() {
        Category category = new Category("X and Y");
        Sku sku = Sku.generate(category, "Phone");
        assertTrue(sku.getValue().startsWith("XAND-"));
    }

    @Test
    void generateSkuMoreTestCases() {
        Sku sku = Sku.generate(new Category("Books"), "El Principito");
        assertTrue(sku.getValue().matches("BOOK-ELPRINCIPI-\\d{5}"));

        sku = Sku.generate(new Category("Home and Kitchen"), "Oven");
        assertTrue(sku.getValue().matches("HOME-OVEN-\\d{5}"));

        sku = Sku.generate(new Category(" Videogames"), "Grand Theft Auto V");
        assertTrue(sku.getValue().matches("VIDE-GRANDTHEFT-\\d{5}"));

        sku = Sku.generate(new Category("Pet Supplies "), "Dog Food  ");
        assertTrue(sku.getValue().matches("PETS-DOGFOOD-\\d{5}"));

        sku = Sku.generate(new Category("PERSONAL CARE"), "SHAMPOO");
        assertTrue(sku.getValue().matches("PERS-SHAMPOO-\\d{5}"));
    }
}