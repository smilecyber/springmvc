package com.cydeo.ecommerce.repository;

import com.cydeo.ecommerce.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    boolean save(Product product);

    Product findProductById(UUID productId);

    List<Product> findAll();
}
