package com.springapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
* Service config will scan all @service component of the application.
* http://javaetmoi.com/2014/06/spring-framework-java-configuration/
*
*/
@Configuration
//@EnableAsync
//@EnableScheduling
//@EnableAspectJAutoProxy
//@EnableCaching
@ComponentScan(value = {"com.springapp.service.support"})
//@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class ServiceConfig {

    private final Logger log = LoggerFactory.getLogger(ServiceConfig.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
