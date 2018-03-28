package com.yf.app.controller;

import com.yf.client.ProductClient;
import com.yf.lib.vo.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RefreshScope
@Slf4j
@Api(value = "ProductController", description = "商品接口")
public class ProductController {

    @Autowired
    private ProductClient productClient;


    @ApiOperation(value = "获取商品Value", httpMethod = "GET", notes = "获取商品Value")
    @ApiImplicitParams({

    })
    @GetMapping("/getProductValue")
    public  String getProductValue(){
        return  productClient.getValue();
    }


    @ApiOperation(value = "添加商品", httpMethod = "POST", notes = "添加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品ID", dataType = "long", paramType = "query",required = true),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "price", value = "价格", dataType = "decimal", paramType = "query",required = true),
    })
    @GetMapping("/addProduct")
    public RespVO addProduct(@RequestParam Long id,
                          @RequestParam String name,
                          @RequestParam BigDecimal price){
        return productClient.addProduct(id,name,price);
    }




}
