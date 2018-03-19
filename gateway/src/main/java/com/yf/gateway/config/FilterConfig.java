package com.yf.gateway.config;
import com.yf.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author QianJH
 */
@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter requestLogFilter() {
        return new AccessFilter();
    }
}
