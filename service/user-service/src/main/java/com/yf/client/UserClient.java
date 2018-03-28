package com.yf.client;
import com.yf.lib.vo.RespVO;
import com.yf.model.TbUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/user/add")
    RespVO addUser(@RequestParam("id") Long id,
                      @RequestParam("userName") String userName,
                      @RequestParam("password") String  password,
                      @RequestParam(value = "salary",required = false) Double salary,
                      @RequestParam(value = "birthday",required = false) Date birthday,
                      @RequestParam(value = "gender",required = false) String gender,
                      @RequestParam(value = "station",required = false) String station,
                      @RequestParam("telPhone") String telPhone,
                      @RequestParam(value = "remark",required = false) String remark);

    @GetMapping("/user/getValue")
    String getValue();

    @PostMapping("/user/login")
    TbUser login(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("password") String password);

    @GetMapping("/user/info")
    TbUser userInfo(@RequestParam("id") Long id);

    @GetMapping("/user/findAll")
    List<TbUser> findAllUser();

    @GetMapping("/user/findByPhone")
    List<TbUser> findByPhone(@RequestParam("phone") String phone);

}
