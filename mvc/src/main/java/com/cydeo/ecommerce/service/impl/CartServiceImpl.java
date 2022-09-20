package com.cydeo.ecommerce.service.impl;

import com.cydeo.ecommerce.model.Cart;
import com.cydeo.ecommerce.model.CartItem;
import com.cydeo.ecommerce.model.Product;
import com.cydeo.ecommerce.service.CartService;
import com.cydeo.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method

        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //delete product object from cart using stream
        return true;
    }
}
