package com.ferdingler.domain.model;

import java.util.UUID;

public class Product {

    private Sku sku;
    private String name;
    private Category category;
    private Price price;

    private Product() {
        // we don't want products to be created without using our factory method.
    }

    public Sku getSku() {
        return sku;
    }

    private void setSku(Sku sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null) {
            throw new RuntimeException("Name cannot be null");
        }

        if(name.isBlank()) {
            throw new RuntimeException("Name cannot be blank");
        }

        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public static Product buildNewProduct(String name, String category, double price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(new Category(category));
        product.setPrice(new Price(price));
        product.setSku(new Sku(UUID.randomUUID().toString()));
        return product;
    }
}
