package com.yf.gateway.config;
import com.yf.gateway.filter.pre.AccessLogFilter;
import com.yf.gateway.filter.pre.RoutesFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {

    @Bean
    public AccessLogFilter requestLogFilter() {
        return new AccessLogFilter();
    }


    @Bean
    public RoutesFilter routesFilter() {
        return new RoutesFilter();
    }



}
