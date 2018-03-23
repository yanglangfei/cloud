package com.yf.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSource {

    String USER_LOGIN="output_user_login";


    /**
     * 用户登录
     * @return
     */
    @Output(USER_LOGIN)
    MessageChannel userLogin();
}
