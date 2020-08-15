package com.ferdingler.infrastructure.services;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.Sku;
import com.ferdingler.domain.services.ShoppingCart;

import java.util.List;

public class MemoryShoppingCart implements ShoppingCart {

    /**
     * Note: A maximum of 10 products should be allowed in the cart.
     * Throw an exception if more than 10 products are added.
     */
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(Sku sku) {

    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public int getCartSize() {
        return 0;
    }

    @Override
    public double calculateCheckoutTotal() {
        return 0;
    }
}
