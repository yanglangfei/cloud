package com.yf.search.repository;

import com.yf.search.model.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface  ESUserInfoRepository extends ElasticsearchRepository<UserInfo,String> {

    UserInfo findByUserName(String userName);
}
