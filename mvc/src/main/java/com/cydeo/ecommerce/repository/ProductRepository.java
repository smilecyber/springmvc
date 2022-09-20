package com.cydeo.ecommerce.repository;

import com.cydeo.ecommerce.model.Product;

public interface ProductRepository {
    boolean save(Product product);
}
