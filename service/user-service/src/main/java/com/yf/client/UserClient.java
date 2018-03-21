package com.yf.client;
import com.yf.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/user/add")
    List<User> getUsers(@RequestParam("name") String name, @RequestParam("id") Long id, @RequestParam("age") Integer age);


    @GetMapping("/user/getValue")
    String getValue();

}
