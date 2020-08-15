package com.ferdingler.infrastructure.services;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.Sku;
import com.ferdingler.domain.services.ShoppingCart;

import java.util.List;

public class MemoryShoppingCart implements ShoppingCart {

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
    public double getCheckoutTotal() {
        return 0;
    }
}
