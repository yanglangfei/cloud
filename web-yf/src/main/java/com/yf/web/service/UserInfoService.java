package com.yf.web.service;

import com.yf.web.model.UserInfo;

public interface UserInfoService {

   UserInfo findByUsername(String userName);
}
