package com.ferdingler.application;

import com.ferdingler.api.ProductInfo;
import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.Sku;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ProductInfoMapperTest {

    private Product product;
    private ProductInfo productInfo;

    @BeforeEach
    void setUp() {
        this.product = Product.buildNewProduct("Banana");
        this.productInfo = ProductInfoMapper.map(product);
    }

    @Test
    public void mapsProductName() {
        assertEquals("Banana", productInfo.getProductName());
    }

    @Test
    public void mapsProductSku() {
        Sku sku = this.product.getSku();
        assertEquals(sku.getValue(), productInfo.getSku());
    }

}