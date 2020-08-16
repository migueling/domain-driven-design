package com.ferdingler.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Sku {

    private final String value;

    public Sku(String value) {
        if(value == null){
            throw new RuntimeException("A sku cannot be null");
        }

        if(value.isEmpty() || value.isBlank()){
            throw new RuntimeException("A sku cannot be empty");
        }

        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * Lab Part 2
     *
     * Modify this method to generate a Sku based on ProductName and Category.
     * The format of the generated sku should be as follows:
     *
     * {First 4 letters of category}-{First 10 letters of product}-{5 random digits}.
     * All uppercase and no spaces allowed.
     *
     * For example
     *
     * Input:
     * ProductName = Mechanic Keyboard
     * Category: Computer Devices
     *
     * Output:
     * COMP-MECHANICKE-48711
     */
    public static Sku generate(Category category, String productName) {
        return new Sku(UUID.randomUUID().toString());
    }

    public static Sku generate() {
        return new Sku(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku = (Sku) o;
        return Objects.equals(value, sku.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
