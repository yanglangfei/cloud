package com.yf.search.service.impl;

import com.yf.search.model.UserInfo;
import com.yf.search.repository.ESUserInfoRepository;
import com.yf.search.service.ESUserInfoService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ESUserInfoServiceImpl implements ESUserInfoService{

    @Autowired
    private ESUserInfoRepository eSUserInfoRepository;

    @Override
    public UserInfo queryUserInfoById(String id) {
        return eSUserInfoRepository.findOne(id);
    }

    @Override
    public UserInfo queryUserInfoByUserName(String userName) {
        return eSUserInfoRepository.findByUserName(userName);
    }

    @Override
    public void save(UserInfo userInfo) {
        eSUserInfoRepository.save(userInfo);
    }

    @Override
    public Iterable<UserInfo> search(QueryStringQueryBuilder queryStringQueryBuilder) {
        return eSUserInfoRepository.search(queryStringQueryBuilder);
    }


}
