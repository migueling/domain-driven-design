package com.ferdingler.domain.model;

import java.util.Objects;

public class Category {

    /**
     * Category is a Value Object
     *
     * Why? Because it doesn't have an identity that we care to
     * persist through the lifecycle of our system. We can
     * safely state that two Categories with the same name are
     * indeed the same Category.
     */
    private String name;

    public Category(String name) {
        if (name == null) {
            throw new RuntimeException("Category name must not be null");
        }

        if (name.isBlank() || name.isEmpty()) {
            throw new RuntimeException("Category name must not be blank");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * A common practice with ValueObject is to override
     * the equals and hashCode methods so that Java knows
     * that two objects with the same attributes are equal
     * to each other.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
