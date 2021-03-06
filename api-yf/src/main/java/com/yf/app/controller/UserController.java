package com.yf.app.controller;
import com.yf.client.UserClient;
import com.yf.lib.vo.RespVO;
import com.yf.model.TbUser;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RefreshScope
@Slf4j
@Api(value = "UserController", description = "用户接口")
public class UserController {

    @Autowired
    private UserClient userClient;

    @ApiOperation(value = "获取用户Value", httpMethod = "GET", notes = "获取用户Value")
    @ApiImplicitParams({

    })
    @GetMapping("/getUserValue")
    public  String getUserValue(HttpServletRequest request){
        String version = request.getHeader("version");
        int remotePort = request.getRemotePort();
        log.info("当前访问 version: {} ,remotePort: {} ,  8084",version,remotePort);
        return  userClient.getValue();
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
    @GetMapping("/addUser")
    public RespVO addUser(@RequestParam Long id,
                             @RequestParam String userName,
                             @RequestParam String  password,
                             @RequestParam(value = "salary",required = false) Double salary,
                             @RequestParam(value = "birthday",required = false) Date birthday,
                             @RequestParam(value = "gender",required = false) String gender,
                             @RequestParam(value = "station",required = false) String station,
                             @RequestParam String telPhone,
                             @RequestParam(value = "remark",required = false) String remark){
        return userClient.addUser(id,userName,password,salary,birthday,gender,station,telPhone,remark);
    }


    @ApiOperation(value = "获取所有用户", httpMethod = "GET", notes = "获取所有用户")
    @ApiImplicitParams({

    })
    @GetMapping("/findAllUser")
    public  List<TbUser> findAllUser(){
        return  userClient.findAllUser();
    }

    @ApiOperation(value = "手机号查询用户", httpMethod = "GET", notes = "手机号查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query",required = true),
    })
    @GetMapping("/findByPhone")
    public  List<TbUser> findByPhone(String phone){
        return  userClient.findByPhone(phone);
    }

    @ApiOperation(value = "用户登录", httpMethod = "GET", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "long", paramType = "query",required = true),
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query",required = true),
    })
    @GetMapping("/login")
    public  TbUser userLogin(@RequestParam Long userId,@RequestParam String name,@RequestParam String password){
        return  userClient.login(userId,name,password);
    }

    @ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "long", paramType = "query",required = true),
    })
    @GetMapping("/userInfo")
    public  TbUser userInfo(@RequestParam Long userId){
        return  userClient.userInfo(userId);
    }


}
