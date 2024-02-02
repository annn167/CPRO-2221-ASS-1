package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();
    private int currentId = 1;

    public Product saveProduct(Product product) {
        // Assign an incremented ID
        product.setId(currentId++);
        productList.add(product);
        return product;
    }

    public Product findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        Product existingProduct = findById(productId);
        if (existingProduct != null) {
            // Update fields of the existing product
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            return existingProduct;
        }
        return null; // or throw an exception if needed
    }

    public void deleteProduct(int productId) {
        productList.removeIf(product -> product.getId() == productId);
    }
}