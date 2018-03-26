package com.yf.service;

import com.yf.model.Product;

import java.util.List;

public interface ProductService {

    List<Product>  findAll();

    List<Product>  findByPhone(String telPhone);


    Integer  addProduct(Product product);
}
