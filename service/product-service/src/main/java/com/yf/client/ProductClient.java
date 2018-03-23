package com.yf.client;

import com.yf.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

//@FeignClient(name = "product-service",fallback = ProductHystrixFallback.class)
@FeignClient("product-service")
public interface ProductClient {

    @PostMapping("/product/add")
    List<Product> getProducts(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("price") BigDecimal price);


    @GetMapping("/product/value")
    String getValue();
}
