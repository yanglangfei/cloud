package com.yf.controller;
import com.yf.event.UserSource;
import com.yf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    private List<User> users=new ArrayList<>();

    @Autowired
    private UserSource userSource;

    @Value("${define.auther}")
    private  String userName;


    @PostMapping("/add")
    public List<User> getUsers(String name,Long id,Integer age){
        User user=new User(id,name,age);
        users.add(user);
        return  users;
    }

    @GetMapping("/getValue")
    public  String getValue(){
     return  userName;
    }

    @PostMapping("/login")
    public  User login(Long id){
        User user=new User(id,"张三",12);
        userSource.userLogin().send(MessageBuilder.withPayload(user).build());
        return user;
    }

}
