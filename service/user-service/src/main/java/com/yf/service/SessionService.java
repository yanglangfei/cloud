package com.yf.service;

import com.yf.model.TbUser;

public interface SessionService {

    void  saveUserToken(Long userId,TbUser user);


    void  clearUserToken(Long userId);


    TbUser getUserToken(Long userId);


}
