package com.cydeo.lab04springmvc.repository.impl;

import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    public static List<Product> PRODUCT_LIST = new ArrayList<>();
    @Override
    public boolean save(Product product){
        PRODUCT_LIST.add(product);
        return true;
    }

    @Override
    public Product findProductById(UUID productId) {
        return PRODUCT_LIST.stream().filter(product -> product.getId().
                toString().equals(productId.toString())).findFirst().orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return PRODUCT_LIST;
    }
}
