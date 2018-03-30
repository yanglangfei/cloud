package com.yf.gateway.config;
import com.yf.gateway.filter.error.ErrorFilter;
import com.yf.gateway.filter.post.ResponseLogFilter;
import com.yf.gateway.filter.pre.AccessLogFilter;
import com.yf.gateway.filter.pre.BlacklistFilter;
import com.yf.gateway.filter.pre.RoutesFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {

    /**
     * @return 路由转发
     */
    @Bean
    public RoutesFilter routesFilter() {
        return new RoutesFilter();
    }


    /**
     * @return 黑名单拦截
     */
    @Bean
    public  BlacklistFilter blacklistFilter(){
        return new BlacklistFilter();
    }

    /**
     * @return 请求日志
     */
    @Bean
    public AccessLogFilter requestLogFilter() {
        return new AccessLogFilter();
    }


    /**
     * @return 响应日志
     */
    @Bean
    public ResponseLogFilter responseLogFilter(){
        return  new ResponseLogFilter();
    }


    /**
     * @return 异常处理
     */
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }




}
