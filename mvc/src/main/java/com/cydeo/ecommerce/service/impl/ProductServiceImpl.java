package com.cydeo.ecommerce.service.impl;

import com.cydeo.ecommerce.model.Product;
import com.cydeo.ecommerce.repository.ProductRepository;
import com.cydeo.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

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
        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
        return productRepository.findProductById(uuid);
    }

}
