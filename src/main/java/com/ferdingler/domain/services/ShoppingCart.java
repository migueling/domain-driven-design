package com.ferdingler.domain.services;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.Sku;

import java.util.List;

public interface ShoppingCart {

    void addProduct(Product product);
    void removeProduct(Sku sku);
    List<Product> getProducts();
    double getCheckoutTotal();

}
