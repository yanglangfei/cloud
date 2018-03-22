package com.yf.app.controller;

import com.yf.client.ProductClient;
import com.yf.client.UserClient;
import com.yf.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
@Api(value = "UserController", description = "用户接口")
public class UserController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;



    @ApiOperation(value = "获取服务信息", httpMethod = "GET", notes = "获取服务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "age", value = "用户年龄", dataType = "int", paramType = "query",required = true),
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", paramType = "query",required = true),
    })
    @GetMapping("/addUser")
    public List<User> getServices(String name, Integer age, Long id){
       return userClient.getUsers(name,id,age);
    }

    @ApiOperation(value = "获取用户Value", httpMethod = "GET", notes = "获取用户Value")
    @ApiImplicitParams({

    })
    @GetMapping("/getUserName")
    public  String getUserValue(){
        return  userClient.getValue();
    }

    @ApiOperation(value = "获取商品Value", httpMethod = "GET", notes = "获取商品Value")
    @ApiImplicitParams({

    })
    @GetMapping("/getProductName")
    public  String getProductName(){
        return  productClient.getValue();
    }

}
