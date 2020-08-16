package com.ferdingler.infrastructure.services;

import com.ferdingler.domain.model.Price;
import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.services.ShoppingCart;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MemoryShoppingCartTest {

    private Product product;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        this.cart = new MemoryShoppingCart();
    }

    Product randomProduct() {
        return Product.buildNewProduct(
                "Dog Food",
                "Pet Supplies",
                5
        );
    }

    @Test
    void newCartStartsWithZeroProducts() {
        assertEquals(0, cart.getCartSize());
    }

    @Test
    void newCartHasZeroCheckoutTotal() {
        assertEquals(0, cart.calculateCheckoutTotal());
    }

    @Test
    void addOneProductToCart() {
        Product product = randomProduct();
        cart.addProduct(product);
        assertEquals(1, cart.getCartSize());
    }

    @Test
    void addedProductCanBeRetrieved() {
        Product product = randomProduct();
        cart.addProduct(product);

        List<Product> productList = cart.getProducts();
        assertEquals(product, productList.get(0));
    }

    @Test
    void noMoreThan10ProductsShouldBeAllowed() {
        for(int i=0; i<10; i++) {
            cart.addProduct(randomProduct());
        }

        assertThrows(RuntimeException.class, () -> {
            cart.addProduct(randomProduct());
        });
    }

    @Test
    void removingProductDecreasesCartSize() {
        Product product = randomProduct();
        cart.addProduct(product);
        assertEquals(1, cart.getCartSize());

        cart.removeProduct(product.getSku());
        assertEquals(0, cart.getCartSize());
    }

    @Test
    void productIsRemovedFromCart() {
        Product product = randomProduct();
        cart.addProduct(product);
        cart.removeProduct(product.getSku());

        List<Product> productList = cart.getProducts();
        assertFalse(productList.contains(product));
    }

    @Test
    void theCorrectProductIsRemovedFromCart() {
        Product productOne = randomProduct();
        Product productTwo = randomProduct();

        cart.addProduct(productOne);
        cart.addProduct(productTwo);
        cart.removeProduct(productOne.getSku());

        List<Product> productList = cart.getProducts();
        assertFalse(productList.contains(productOne));
        assertTrue(productList.contains(productTwo));
    }

    @Test
    void checkoutTotalIsCalculatedForOneProduct() {
        Product product = randomProduct();
        Price price = product.getPrice();

        cart.addProduct(product);

        assertEquals(price.getValue(), cart.calculateCheckoutTotal());
    }

    @Test
    void checkoutTotalIsCalculatedForMultipleProducts() {
        int numProducts = 1 + new Random().nextInt(10);
        for(int i=0; i<numProducts; i++) {
            cart.addProduct(randomProduct());
        }

        List<Product> productList = cart.getProducts();
        double expectedTotal = 0;
        for(Product product : productList) {
            expectedTotal += product.getPrice().getValue();
        }

        assertEquals(expectedTotal, cart.calculateCheckoutTotal());
    }
}