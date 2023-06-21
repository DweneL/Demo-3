package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Rest controllers does a bunch
// makes the class an api controller, also turns the list into a Json
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


    // to get it by ID
    // After product that's where you put the id number
    //you have to differ the get methods
    // if you have two of the same endpoints the computer will not know which one to get to
    @GetMapping("api/product/{id}")
    public Product getProductById(@PathVariable int id){
        return this.productService.getProductById(id);

    }


    // added name at the end to differentiate it
    //query string parameters begin with a question mark
    //api/product/name?name=Wheat Bread
    @GetMapping("api/product/name")
    public Product getProductByName(@RequestParam("name") String name){
        //once you see that question mark replace it with name and save it within the variable "String name"

        return this.productService.getProductByName(name);
    }


    // this is to delete a product, and it can be deleted by the id of the product
    @DeleteMapping("api/product/{id}")
    public void deleteProduct(@PathVariable int id){
        this.productService.deleteProduct(id);
    }


    // you should be sure that they are updating the thing by its id
    @PutMapping("api/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
    return this.productService.updateProduct(product, id);

    }

}
