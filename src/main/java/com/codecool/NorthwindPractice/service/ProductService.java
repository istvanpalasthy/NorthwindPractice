package com.codecool.NorthwindPractice.service;

import com.codecool.NorthwindPractice.model.Product;
import com.codecool.NorthwindPractice.model.User;
import com.codecool.NorthwindPractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }
}
