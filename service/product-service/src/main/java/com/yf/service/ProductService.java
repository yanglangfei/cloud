package com.yf.service;

import com.yf.model.TbProduct;

import java.util.List;

public interface ProductService {

    List<TbProduct>  findAll();

    List<TbProduct>  findByName(String name);


    Integer  addProduct(TbProduct product);
}
