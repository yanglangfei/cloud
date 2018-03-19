package com.yf.app.controller;

import com.yf.client.UserClient;
import com.yf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/addUser")
    public List<User> getServices(String name, Integer age, Long id){
       return userClient.getUsers(name,id,age);
    }

}
