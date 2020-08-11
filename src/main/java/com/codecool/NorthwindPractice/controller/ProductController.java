package com.codecool.NorthwindPractice.controller;

import com.codecool.NorthwindPractice.model.Product;
import com.codecool.NorthwindPractice.model.User;
import com.codecool.NorthwindPractice.service.ProductService;
import com.codecool.NorthwindPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public Iterable<Product> getAll() {
        return productService.getAll();
    }
}
