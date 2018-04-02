package com.yf.search.controller;

import com.yf.search.model.UserInfo;
import com.yf.search.service.ESUserInfoService;
import org.elasticsearch.action.update.UpdateHelper;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    private ESUserInfoService eSUserInfoService;

    @RequestMapping("/{id}")
    public UserInfo queryAccountInfo(@PathVariable("id") String id) {
        UserInfo accountInfo = eSUserInfoService.queryUserInfoById(id);
        return accountInfo;
    }

    @RequestMapping("/query/{userName}")
    public UserInfo queryAccountInfoByAccountName(@PathVariable("userName") String userName) {
        UserInfo userInfo = eSUserInfoService.queryUserInfoByUserName(userName);
        return userInfo;
    }

    @RequestMapping("/save")
    public String save(@Valid UserInfo accountInfo) {
        eSUserInfoService.save(accountInfo);
        return "保存成功";
    }


    @RequestMapping("/search")
    public List<UserInfo> search(@RequestParam String searchKey) {
        List<UserInfo> userInfos=new ArrayList<>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchKey);
        Iterable<UserInfo> searchResult = eSUserInfoService.search(builder);
        Iterator<UserInfo> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            UserInfo userInfo = iterator.next();
            userInfos.add(userInfo);
        }
        return userInfos;
    }

}
