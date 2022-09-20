package com.cydeo.ecommerce.service.impl;

import com.cydeo.ecommerce.model.Product;
import com.cydeo.ecommerce.repository.ProductRepository;
import com.cydeo.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.cydeo.ecommerce.repository.impl.ProductRepositoryImpl.PRODUCT_LIST;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean productCreate(Product product){
        // todo implement method
        return true;
    }

    @Override
    public List<Product> listProduct() {
        // todo implement method
        return new ArrayList<>();
    }

    @Override
    public Product findProductById(UUID uuid){
        // todo implement method
        return new Product();
    }

}
