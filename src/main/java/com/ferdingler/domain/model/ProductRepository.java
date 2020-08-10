package com.ferdingler.domain.model;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();
    void save(Product product);

}
