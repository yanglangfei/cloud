package com.yf.client;

import com.yf.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductHystrixFallback implements ProductClient {
    @Override
    public List<Product> getProducts(Long id, String name, BigDecimal price) {
        return null;
    }

    @Override
    public String getValue() {
        return "";
    }
}
