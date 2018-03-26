package com.yf.controller;

import com.yf.model.Product;
import com.yf.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
@RefreshScope
@Slf4j
public class ProductController {
    private List<Product> products = new ArrayList<>();

    @Autowired
    private ProductService productService;

    @Value("${define.product}")
    private String productName;

    @PostMapping("/add")
    public void addProduct(@RequestParam("id") Long id,
                           @RequestParam("userName") String userName,
                           @RequestParam("password") String  password,
                           @RequestParam(value = "salary",required = false) Double salary,
                           @RequestParam(value = "birthday",required = false) Date birthday,
                           @RequestParam(value = "gender",required = false) String gender,
                           @RequestParam(value = "station",required = false) String station,
                           @RequestParam("telPhone") String telPhone,
                           @RequestParam(value = "remark",required = false) String remark) {
        Product product = new Product(id, userName, password,salary,birthday,gender,station,telPhone,remark);
        Integer addResult = productService.addProduct(product);
        log.info("添加User {}",addResult);
    }


    @GetMapping("/value")
    public String getValue() {
        return productName;
    }

    @GetMapping("/findAll")
    public  List<Product> findAllProduct(){
        return productService.findAll();
    }


    @GetMapping("/findByPhone")
    public  List<Product> findByPhone(String phone){
        return productService.findByPhone(phone);
    }


}
