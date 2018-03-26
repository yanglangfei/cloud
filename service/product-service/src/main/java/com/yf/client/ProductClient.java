package com.yf.client;

import com.yf.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@FeignClient(name = "product-service",fallback = ProductHystrixFallback.class)
@FeignClient("product-service")
public interface ProductClient {

    @PostMapping("/product/add")
    void addProduct(@RequestParam("id") Long id,
                     @RequestParam("userName") String userName,
                     @RequestParam("password") String  password,
                     @RequestParam(value = "salary",required = false) Double salary,
                     @RequestParam(value = "birthday",required = false) Date birthday,
                     @RequestParam(value = "gender",required = false) String gender,
                     @RequestParam(value = "station",required = false) String station,
                     @RequestParam("telPhone") String telPhone,
                     @RequestParam(value = "remark",required = false) String remark);


    @GetMapping("/product/value")
    String getValue();


    @GetMapping("/product/findAll")
    List<Product> findAllProduct();

    @GetMapping("/product/findByPhone")
    List<Product> findByPhone(@RequestParam("phone") String phone);
}
