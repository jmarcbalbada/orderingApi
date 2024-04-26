package com.example.orderapi.service;
import com.example.orderapi.entity.Product;
import com.example.orderapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product modifyProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getProductId());
        if (existingProduct.isPresent()) {
            // Update the existing product with new values from the provided product object
            existingProduct.get().setProductPrice(product.getProductPrice());
            existingProduct.get().setProductType(product.getProductType());
            // Update other fields as needed
            return productRepository.save(existingProduct.get());
        } else {
            throw new RuntimeException("Product with ID " + product.getProductId() + " not found");
        }
    }

    public Product selectProduct(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
