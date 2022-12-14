package com.cydeo.ecommerce.controller;

import com.cydeo.ecommerce.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.cydeo.ecommerce.service.impl.CartServiceImpl.CART;

@Controller
@RequestMapping("/")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart")
    public String index(Model model){
        model.addAttribute("cart", CART);
        return "cart/show-cart";
    }

    @RequestMapping("/addToCart/{productId}/{qt}")
    public String addToCart(@PathVariable("productId")UUID productId, @PathVariable("qt") Integer quantity, Model model){
        cartService.addToCart(productId, quantity);
        model.addAttribute("cart", CART);
        return "cart/show-cart";
    }

    @RequestMapping("/delete/{productId}")
    public String delete(@PathVariable("productId")UUID productId, Model model){
        cartService.deleteFromCart(productId);
        model.addAttribute("cart", CART);
        return "cart/show-cart";
    }
}
