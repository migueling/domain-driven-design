package com.ferdingler.infrastructure.services;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.Sku;
import com.ferdingler.domain.services.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class MemoryShoppingCart implements ShoppingCart {

    private final int MAX_PRODUCTS = 10;
    private final List<Product> products;

    public MemoryShoppingCart() {
        this.products = new ArrayList<>();
    }

    /**
     * Note: A maximum of 10 products should be allowed in the cart.
     * Throw an exception if more than 10 products are added.
     */
    @Override
    public void addProduct(Product product) {
        if(products.size() >= MAX_PRODUCTS) {
            throw new RuntimeException("Sorry, no more than 10 products");
        }

        products.add(product);
    }

    @Override
    public void removeProduct(Sku sku) {
        products.removeIf(product -> product.getSku().equals(sku));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public int getCartSize() {
        return products.size();
    }

    @Override
    public double calculateCheckoutTotal() {
        return products.stream()
                .map(product -> product.getPrice().getValue())
                .reduce(0.0, Double::sum);
    }
}
