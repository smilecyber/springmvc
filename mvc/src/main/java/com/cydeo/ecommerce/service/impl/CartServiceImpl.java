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
        Product product = productService.findProductById(productId);

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);

        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        CART.getCartItemList().add(cartItem);
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        return CART.getCartItemList().removeIf(cartItem ->
                cartItem.getProduct().getId().toString().
                equals(productId.toString()));
    }
}
