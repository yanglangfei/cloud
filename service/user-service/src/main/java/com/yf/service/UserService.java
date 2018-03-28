package com.yf.service;

import com.yf.model.TbUser;

import java.util.List;

public interface UserService {

    List<TbUser>  findAll();

    List<TbUser>  findByPhone(String telPhone);


    Integer  addUser(TbUser product);
}
