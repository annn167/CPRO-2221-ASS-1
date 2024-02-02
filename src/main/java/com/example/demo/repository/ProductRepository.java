package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Product save(Product product) {
        // Assuming your IDs are unique
        productList.add(product);
        return product;
    }

    public void deleteById(int id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
