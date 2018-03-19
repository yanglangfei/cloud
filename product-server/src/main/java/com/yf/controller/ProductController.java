package com.yf.controller;

import com.yf.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    private List<Product> products=new ArrayList<>();

    @PostMapping("/add")
    public List<Product>  getProducts(Long id, String name, BigDecimal price){
        Product product=new Product(id,name,price);
        products.add(product);
        return products;

    }
}
