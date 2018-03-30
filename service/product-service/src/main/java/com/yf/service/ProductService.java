package com.yf.service;

import com.yf.model.TbProduct;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<TbProduct>  findAll();

    List<TbProduct>  findByName(String name);


    Integer  addProduct(TbProduct product);


    Integer deleteProduct(Long id);

    Integer updateProduct(Long id,String name, BigDecimal price);
}
