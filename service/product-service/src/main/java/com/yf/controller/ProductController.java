package com.yf.controller;

import com.yf.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@RefreshScope
public class ProductController {
    private List<Product> products = new ArrayList<>();

    @Value("${define.product}")
    private String productName;

    @PostMapping("/add")
    public List<Product> getProducts(Long id, String name, BigDecimal price) {
        Product product = new Product(id, name, price);
        products.add(product);
        return products;
    }


    @GetMapping("/value")
    public String getValue() {
        return productName;
    }

}
