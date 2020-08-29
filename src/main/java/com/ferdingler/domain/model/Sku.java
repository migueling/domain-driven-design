package com.ferdingler.domain.model;

import java.util.Objects;
import java.util.Random;
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

    public static Sku generate(Category category, String productName) {

        int MAX_CATEGORY_PREFIX_SIZE = 4;
        int MAX_PRODUCT_NAME_SIZE = 10;

        StringBuilder skuBuilder = new StringBuilder();
        String prefix = category.getName().replace(" ", "");
        String productStr = productName.replace(" ", "");

        if (productStr.length() >= MAX_PRODUCT_NAME_SIZE) {
            productStr = productStr.substring(0, MAX_PRODUCT_NAME_SIZE);
        }

        if(prefix.length() >= MAX_CATEGORY_PREFIX_SIZE) {
            prefix = prefix.substring(0, MAX_CATEGORY_PREFIX_SIZE);
        }

        Random random = new Random();
        String digits = String.valueOf(10000 + random.nextInt(90000));

        skuBuilder
                .append(prefix)
                .append("-")
                .append(productStr)
                .append("-")
                .append(digits);

        return new Sku(skuBuilder.toString().toUpperCase());
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
