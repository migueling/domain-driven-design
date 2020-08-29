package com.ferdingler.infrastructure.database;

import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.ProductRepository;
import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Requires(property = "flags.productRepository", value = "Hardcoded")
public class HardcodedProductRepository implements ProductRepository {

    private final List<Product> productList;

    public HardcodedProductRepository() {
        this.productList = new ArrayList<>();
        this.productList.add(Product.buildNewProduct("Bananas", "Fruit", 9.5));
        this.productList.add(Product.buildNewProduct("Strawberries", "Fruit", 12));
        this.productList.add(Product.buildNewProduct("Apples", "Fruit", 15));
        this.productList.add(Product.buildNewProduct("Grapes", "Fruit", 10));
        this.productList.add(Product.buildNewProduct("Melon", "Fruit", 9.5));
    }

    @Override
    public List<Product> getAll() {
        return this.productList;
    }

    @Override
    public void save(Product product) {
        this.productList.add(product);
    }
}
