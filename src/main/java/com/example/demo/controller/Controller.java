package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class Controller {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Retrieve all products
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }


    // Retrieve a specific product by ID
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    // Update an existing product
    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
        Product updatedProductResult = productService.updateProduct(productId, updatedProduct);

        if (updatedProductResult != null) {
            // Product updated successfully
            String successMessage = "Product with id " + productId + " updated successfully.";
            return ResponseEntity.ok(successMessage);
        } else {
            // Product not found
            String errorMessage = "Product with id " + productId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    // Delete a product by ID
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        String successMessage = "Product with id " + productId + " deleted successfully.";
        return ResponseEntity.ok(successMessage);
    }

}
