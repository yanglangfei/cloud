package com.yf.service.impl;
import com.yf.mapper.TbUserMapper;
import com.yf.model.TbUser;
import com.yf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;


    @Override
    public List<TbUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<TbUser> findByPhone(String telPhone) {
        Map<String, Object> param=new HashMap<>();
        param.put("telPhone",telPhone);
        return userMapper.findList(param);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer addUser(TbUser user) {
        return userMapper.save(user);

    }
}
