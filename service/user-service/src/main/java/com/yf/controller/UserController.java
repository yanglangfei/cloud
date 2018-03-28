package com.yf.controller;
import com.yf.event.UserSource;
import com.yf.lib.vo.RespVO;
import com.yf.lib.vo.RespVOBuilder;
import com.yf.model.TbUser;
import com.yf.service.SessionService;
import com.yf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserSource userSource;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${define.auther}")
    private  String auther;


    @PostMapping("/add")
    public RespVO addProduct(@RequestParam("id") Long id,
                             @RequestParam("userName") String userName,
                             @RequestParam("password") String  password,
                             @RequestParam(value = "salary",required = false) Double salary,
                             @RequestParam(value = "birthday",required = false) Date birthday,
                             @RequestParam(value = "gender",required = false) String gender,
                             @RequestParam(value = "station",required = false) String station,
                             @RequestParam("telPhone") String telPhone,
                             @RequestParam(value = "remark",required = false) String remark) {
        TbUser user = new TbUser(id, userName, password,salary,birthday,gender,station,telPhone,remark);
        Integer addResult = userService.addUser(user);
        log.info("添加User {}",addResult);
        return RespVOBuilder.success();
    }

    @GetMapping("/getValue")
    public  String getValue(){
     return  auther;
    }

    @PostMapping("/login")
    public  TbUser login(Long id,String userName,String password){
        TbUser user=new TbUser();
        user.setUserName(userName);
        user.setPassword(password);
        user.setId(id);
        // redis 存储用户信息
        sessionService.saveUserToken(id,user);
        //发送消息到 product 队列
        amqpTemplate.convertAndSend("product",userName);
        boolean send = userSource.userLogin().send(MessageBuilder.withPayload(user).build());
        log.info("消息发送成功-----",send);
        return user;
    }


    @GetMapping("/info")
    public  TbUser userInfo(Long id){
        // redis 存储用户信息
        TbUser user = sessionService.getUserToken(id);
        return user;
    }

    @GetMapping("/findAll")
    public  List<TbUser> findAllUser(){
        return userService.findAll();
    }


    @GetMapping("/findByPhone")
    public  List<TbUser> findByPhone(String phone){
        return userService.findByPhone(phone);
    }

}
