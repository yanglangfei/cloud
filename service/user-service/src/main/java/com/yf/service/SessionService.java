package com.yf.service;

import com.yf.model.User;

public interface SessionService {

    void  saveUserToken(Long userId,User user);


    void  clearUserToken(Long userId);


    User getUserToken(Long userId);


}
