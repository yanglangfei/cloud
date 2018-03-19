package com.yf.client;

import com.yf.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @PostMapping("/add")
    List<Product> getProducts(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("price") BigDecimal price);
}
