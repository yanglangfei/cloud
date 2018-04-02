package com.yf.web.service.impl;

import com.yf.web.model.UserInfo;
import com.yf.web.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo findByUsername(String userName) {
        return null;
    }
}
