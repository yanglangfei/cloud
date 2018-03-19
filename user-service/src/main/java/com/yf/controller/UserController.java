package com.yf.controller;
import com.yf.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    List<User> users=new ArrayList<>();


    @PostMapping("/add")
    public List<User> getUsers(String name,Long id,Integer age){
        User user=new User(id,name,age);
        users.add(user);
        return  users;
    }

}
