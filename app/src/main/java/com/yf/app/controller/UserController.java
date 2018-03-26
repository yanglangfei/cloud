package com.yf.app.controller;

import com.yf.client.ProductClient;
import com.yf.client.UserClient;
import com.yf.lib.vo.RespVO;
import com.yf.model.Product;
import com.yf.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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


    @ApiOperation(value = "添加用户", httpMethod = "POST", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "long", paramType = "query",required = true),
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "salary", value = "薪资", dataType = "double", paramType = "query"),
            @ApiImplicitParam(name = "birthday", value = "生日", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "gender", value = "性别", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "station", value = "状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "telPhone", value = "手机号", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "remark", value = "备注", dataType = "String", paramType = "query"),
    })
    @GetMapping("/addProduct")
    public RespVO addProduct(@RequestParam Long id,
                             @RequestParam String userName,
                             @RequestParam String  password,
                             @RequestParam(value = "salary",required = false) Double salary,
                             @RequestParam(value = "birthday",required = false) Date birthday,
                             @RequestParam(value = "gender",required = false) String gender,
                             @RequestParam(value = "station",required = false) String station,
                             @RequestParam String telPhone,
                             @RequestParam(value = "remark",required = false) String remark){
        return productClient.addProduct(id,userName,password,salary,birthday,gender,station,telPhone,remark);
    }


    @ApiOperation(value = "获取所有用户", httpMethod = "GET", notes = "获取所有用户")
    @ApiImplicitParams({

    })
    @GetMapping("/findAllProduct")
    public  List<Product> findAllProduct(){
        return  productClient.findAllProduct();
    }

    @ApiOperation(value = "手机号查询用户", httpMethod = "GET", notes = "手机号查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query",required = true),
    })
    @GetMapping("/findByPhone")
    public  List<Product> findByPhone(String phone){
        return  productClient.findByPhone(phone);
    }

    @ApiOperation(value = "用户登录", httpMethod = "POST", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "long", paramType = "query",required = true),
    })
    @GetMapping("/login")
    public  User userLogin(@RequestParam Long userId){
        return  userClient.login(userId);
    }

}
