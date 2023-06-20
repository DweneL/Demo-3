package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;

    }

    @GetMapping("api/product")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PostMapping("api/product")
    public Product createproduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

}