package com.cydeo.ecommerce.repository.impl;

import com.cydeo.ecommerce.model.Product;
import com.cydeo.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    public static List<Product> PRODUCT_LIST = new ArrayList<>();
    @Override
    public boolean save(Product product){
        PRODUCT_LIST.add(product);
        return true;
    }
}
