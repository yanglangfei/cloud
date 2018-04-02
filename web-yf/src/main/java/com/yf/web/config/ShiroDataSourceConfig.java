package com.yf.web.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="shiroEntityManagerFactory",
        transactionManagerRef="shiroTransactionManager",
        basePackages= { "com.yf.web.dao" })
public class ShiroDataSourceConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("shiroDataSource")
    private DataSource shiroDataSource;

    @Bean(name = "shiroEntityManager")
    public EntityManager shiroEntityManager(EntityManagerFactoryBuilder builder) {
        return shiroEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "shiroEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean shiroEntityManagerFactory (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(shiroDataSource)
                .properties(getVendorProperties(shiroDataSource))
                .packages("com.xxx.shiro.entity")
                .persistenceUnit("shiroPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "shiroTransactionManager")
    PlatformTransactionManager shiroTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(shiroEntityManagerFactory(builder).getObject());
    }



}
