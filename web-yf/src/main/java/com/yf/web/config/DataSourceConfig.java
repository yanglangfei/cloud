package com.yf.web.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    /**
     * shiro数据源
     * @return
     */
    @Bean(name = "shiroDataSource")
    @Qualifier("shiroDataSource")
    @ConfigurationProperties(prefix="spring.datasource.shiro")
    public DataSource shiroDataSource() {
        return DataSourceBuilder.create().build();
    }
}
