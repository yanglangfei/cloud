package com.yf.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserSkin {

    String USER_LOGIN="input_user_login";

    /**
     * 用户登录
     * @return
     */
    @Input(UserSkin.USER_LOGIN)
    SubscribableChannel userLogin();

}
