package com.datajpa.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfig {
    @Value("${spring.db.driverClassName}")
    private String driverClass;
    @Value("${spring.db.url}")
    private String url;
    @Value("${spring.db.username}")
    private String user;
    @Value("${spring.db.password}")
    private String password;
    @Value("${spring.datasource.initialPoolSize:30}")
    private int initialPoolSize;
    @Value("${spring.datasource.maxActive:100}")
    private int maxActive;


    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setInitialSize(initialPoolSize);
        dataSource.setMaxActive(maxActive);
        return dataSource;
    }
}
