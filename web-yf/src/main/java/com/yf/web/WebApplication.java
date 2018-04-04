package com.yf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);

    }


    /**
     * 启动应用
     **/
    public void start(){
        // 第一步：启动应用服务……

        // 第二步：注册JDK钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The hook running...");
                //第三步：调用停机处理
                stop();
            }
        }));
    }

    /**
     * 停止应用
     **/
    public void stop(){
        // 停止应用前停机处理(如：注销服务、标记不接受请求等)
    }


}
