package com.yf.service;

import com.alibaba.fastjson.JSONObject;
import com.yf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private  String USER_TOKEN_KEY="USER_TOKEN_";

    private  String USER_SESSION_KEY="USER_SESSION_";

    private  Long SAVE_TIME=7L;

    @Override
    public void saveUserToken(Long userId,User user) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String uuid=UUID.randomUUID().toString().replace("-","");
        operations.set(USER_TOKEN_KEY+userId,uuid,SAVE_TIME,TimeUnit.DAYS);
        String jsonString = JSON.toJSONString(user);
        operations.set(USER_SESSION_KEY+uuid,jsonString,SAVE_TIME, TimeUnit.DAYS);
    }

    @Override
    public void clearUserToken(Long userId) {
        if(stringRedisTemplate.hasKey(USER_TOKEN_KEY+userId)){
            stringRedisTemplate.delete(USER_TOKEN_KEY + userId);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String uuid = operations.get(USER_TOKEN_KEY + userId);
            if(stringRedisTemplate.hasKey(USER_SESSION_KEY+uuid)){
                stringRedisTemplate.delete(USER_SESSION_KEY + uuid);
            }
        }
    }

    @Override
    public User getUserToken(Long userId) {
        if(!stringRedisTemplate.hasKey(USER_TOKEN_KEY+userId)){
            return null;
        }
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String uuid = operations.get(USER_TOKEN_KEY + userId);
        if(!stringRedisTemplate.hasKey(USER_SESSION_KEY+uuid)){
            return null;
        }
        String userStr = operations.get(USER_SESSION_KEY + uuid);
        User user = JSONObject.parseObject(userStr, User.class);
        return user;
    }
}
