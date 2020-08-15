package com.ferdingler.domain.model;

import java.util.Objects;

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
