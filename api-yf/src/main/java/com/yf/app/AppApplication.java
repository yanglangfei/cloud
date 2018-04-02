package com.yf.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(basePackages = "com.yf.client")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class,args);
    }
}
