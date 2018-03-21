package com.yf.gateway.config;
import com.yf.gateway.filter.pre.AccessLogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author QianJH
 */
@Configuration
public class FilterConfig {

    @Bean
    public AccessLogFilter requestLogFilter() {
        return new AccessLogFilter();
    }
}
