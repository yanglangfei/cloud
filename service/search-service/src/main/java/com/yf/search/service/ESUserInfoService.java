package com.yf.search.service;

import com.yf.search.model.UserInfo;
import org.elasticsearch.index.query.QueryStringQueryBuilder;

public interface ESUserInfoService {

     UserInfo queryUserInfoById(String id);

     UserInfo queryUserInfoByUserName(String userName);

     void save(UserInfo userInfo);

     Iterable<UserInfo> search(QueryStringQueryBuilder queryStringQueryBuilder);
}
