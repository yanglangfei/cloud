package com.yf.controller;
import com.yf.event.UserSource;
import com.yf.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
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
@Slf4j
public class UserController {

    private List<User> users=new ArrayList<User>();

    @Autowired
    private UserSource userSource;

    @Autowired
    private AmqpTemplate amqpTemplate;

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
        //发送消息到 product 队列
        amqpTemplate.convertAndSend("product","I am a user");
        boolean send = userSource.userLogin().send(MessageBuilder.withPayload(user).build());
        log.info("消息发送成功-----",send);
        return user;
    }

}
