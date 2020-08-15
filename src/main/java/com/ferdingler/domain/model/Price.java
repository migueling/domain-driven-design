package com.ferdingler.domain.model;

import java.util.Objects;

public class Price {

    private final double value;

    public Price(double value) {

        if(value < 0) {
            throw new RuntimeException("Price cannot be less than zero");
        }

        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
