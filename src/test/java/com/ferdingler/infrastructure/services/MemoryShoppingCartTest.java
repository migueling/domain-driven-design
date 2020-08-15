package com.ferdingler.infrastructure.services;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.services.ShoppingCart;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MemoryShoppingCartTest {

    @Test
    public void newCartStartsWithZeroProducts() {
        ShoppingCart cart = new MemoryShoppingCart();
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void newCartHasZeroCheckoutTotal() {
        ShoppingCart cart = new MemoryShoppingCart();
        assertEquals(0, cart.calculateCheckoutTotal());
    }

    @Test
    public void addOneProductToCart() {
        Product product = Product.buildNewProduct("Dog Food", "Pet Supplies", 5);
        ShoppingCart cart = new MemoryShoppingCart();
        cart.addProduct(product);
        assertEquals(1, cart.getProducts().size());
    }

}