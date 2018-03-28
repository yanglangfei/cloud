package com.yf.service.impl;
import com.yf.mapper.TbProductMapper;
import com.yf.model.TbProduct;
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
    private TbProductMapper productMapper;


    @Override
    public List<TbProduct> findAll() {
        return productMapper.findAll();
    }

    @Override
    public List<TbProduct> findByName(String name) {
        Map<String, Object> param=new HashMap<>();
        param.put("name",name);
        return productMapper.findList(param);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer addProduct(TbProduct product) {
        return productMapper.save(product);

    }
}
