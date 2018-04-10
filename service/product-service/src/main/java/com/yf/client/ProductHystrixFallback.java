package com.yf.client;

import com.yf.lib.vo.RespVO;
import com.yf.lib.vo.RespVOBuilder;
import com.yf.model.TbProduct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductHystrixFallback implements ProductClient {


    @Override
    public RespVO addProduct(Long id, String name, BigDecimal price) {
        return RespVOBuilder.failure();
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public List<TbProduct> findAllProduct() {
        return null;
    }

    @Override
    public List<TbProduct> findByName(String name) {
        return null;
    }

    @Override
    public Integer updateProduct(Long id, String name, BigDecimal price) {
        return -1;
    }

    @Override
    public Integer deleteProduct(Long id) {
        return -1;
    }


}
