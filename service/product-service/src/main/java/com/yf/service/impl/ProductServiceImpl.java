package com.yf.service.impl;

import com.yf.mapper.ProductMapper;
import com.yf.model.Product;
import com.yf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public List<Product> findByPhone(String telPhone) {
        Map<String, Object> param=new HashMap<>();
        param.put("telPhone",telPhone);
        return productMapper.findList(param);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer addProduct(Product product) {
        return productMapper.save(product);

    }
}
