package com.example.orderapi.controller;

import com.example.orderapi.entity.Product;
import com.example.orderapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

//    @PutMapping("/{productId}")
//    public Product modifyProduct(@PathVariable int productId, @RequestBody Product product) {
//        product.setProductId(productId); // Ensure ID remains the same
//        return productService.modifyProduct(product);
//    }

//    @GetMapping("/{productId}")
//    public Product selectProduct(@PathVariable int productId) {
//        return productService.selectProduct(productId);
//    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
