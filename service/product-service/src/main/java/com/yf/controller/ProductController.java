package com.yf.controller;

import com.yf.lib.vo.RespVO;
import com.yf.lib.vo.RespVOBuilder;
import com.yf.model.TbProduct;
import com.yf.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@RefreshScope
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${define.product}")
    private String productName;

    @PostMapping("/add")
    public RespVO addProduct(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("price") BigDecimal price
                             ) {
        TbProduct product = new TbProduct(id, name, price);
        Integer addResult = productService.addProduct(product);
        log.info("添加product {}",addResult);
        return RespVOBuilder.success();
    }


    @GetMapping("/value")
    public String getValue() {
        return productName;
    }

    @GetMapping("/findAll")
    public  List<TbProduct> findAllProduct(){
        return productService.findAll();
    }


    @GetMapping("/findByName")
    public  List<TbProduct> findByPhone(String name){
        return productService.findByName(name);
    }


}
