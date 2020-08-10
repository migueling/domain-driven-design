package com.ferdingler.application;

import com.ferdingler.api.CreateProductRequest;
import com.ferdingler.api.ProductInfo;
import com.ferdingler.domain.model.Product;
import com.ferdingler.domain.model.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogApplication {

    @Inject
    private ProductRepository productRepository;

    public List<ProductInfo> listProducts() {
        List<Product> productList = productRepository.getAll();
        return productList.stream().map(ProductInfoMapper::map).collect(Collectors.toList());
    }

    public void createProduct(CreateProductRequest request) {
        Product product = Product.buildNewProduct(request.getProductName(), request.getCategoryName());
        productRepository.save(product);
    }

}
