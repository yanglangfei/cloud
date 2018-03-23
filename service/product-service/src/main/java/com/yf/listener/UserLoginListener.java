package com.yf.listener;

import com.alibaba.fastjson.JSONObject;
import com.yf.event.UserSkin;
import com.yf.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(UserSkin.class)
public class UserLoginListener {

    @StreamListener(UserSkin.USER_LOGIN)
    public  void  onUserLogin(Message<String> message){
        log.info("监听到用户登录事件 {}",message);
        User user = JSONObject.parseObject(message.getPayload(), User.class);
        log.info("用户 {} 登录成功",user);

    }

}
