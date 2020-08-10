package com.ferdingler.domain.model;

import java.util.UUID;

public class Product {

    private Sku sku;
    private String name;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Product buildNewProduct(String name) {
        Product product = new Product();
        product.setName(name);
        product.setSku(new Sku(UUID.randomUUID().toString()));
        return product;
    }
}
