package com.springapp.config;

import com.springapp.config.core.DataSourceInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = {"com.springapp.dao.support"})
@EnableCaching(mode = AdviceMode.PROXY)
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = false)
public class DaoConfig {
    
//    @Value("${jdbc.driverClassName}") String dbDriver;
//    @Value("${jdbc.url}") String dbUrl;
//    @Value("${jdbc.user}") String dbUser;
//    @Value("${jdbc.pass}") String dbPassword;

    @Autowired
    private Environment env;

    /**
     * As opposed to using XML namespace element, 
     * * the Java @PropertySource annotation does not automatically register a PropertySourcesPlaceholderConfigurer with Spring. 
     * * Instead, the bean must be explicitly defined in the configuration to get the property resolution mechanism working.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        
        // initialize db
        DataSourceInitializer dsInitializer= new DataSourceInitializer();
        dsInitializer.initialize(dataSource);
        
        return dataSource;
    }

    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("users");
    }

}
