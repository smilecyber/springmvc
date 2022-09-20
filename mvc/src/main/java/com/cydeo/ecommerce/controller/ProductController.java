package com.cydeo.ecommerce.controller;

import com.cydeo.ecommerce.model.Product;
import com.cydeo.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.cydeo.ecommerce.service.impl.CartServiceImpl.CART;

@Controller
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listProduct(Model model){
        model.addAttribute("productList", productService.listProduct());
        model.addAttribute("cartTotalAmount", CART.getCartTotalAmount());
        return "product/list";
    }

    @GetMapping("/create-form")
    public String getCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "/product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product, Model model){
        productService.productCreate(product);

        model.addAttribute("productList", productService.listProduct());
        return "product/list";
    }
}
