package com.ferdingler.domain.model;

import com.ferdingler.infrastructure.config.FeatureFlags;

import javax.inject.Inject;

public class ProductFactory {

    @Inject
    private FeatureFlags featureFlags;

    public Product buildNewProduct(String name, String category, double price) {
        Product product = new Product();
        Category cat = new Category(category);
        product.setName(name);
        product.setCategory(cat);
        product.setPrice(new Price(price));
        if(featureFlags.getSkuGenerationStrategy().equals("Legacy")) {
            product.setSku(Sku.generate());
        } else {
            product.setSku(Sku.generate(cat, name));
        }
        return product;
    }
}
