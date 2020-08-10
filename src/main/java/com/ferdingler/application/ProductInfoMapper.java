package com.ferdingler.application;

import com.ferdingler.api.ProductInfo;
import com.ferdingler.domain.model.Product;

public class ProductInfoMapper {

    public static ProductInfo map(Product product) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName(product.getName());
        productInfo.setSku(product.getSku().getValue());
        productInfo.setCategory(product.getCategory().getName());
        return productInfo;
    }

}
