package com.datajpa.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@EnableConfigurationProperties(DataSourceConfig.class)
// 该注解是把application.properties中的配置映射到DataSourceConfig类中,
// DataSourceConfig用@ConfigurationProperties(prefix = "spring.data.mongodb")注解key-value
// DataSourceConfig中必须加setter, getter方法，属性名和key对应

@Configuration
@EntityScan("com.datajpa.example.entity")
@EnableJpaRepositories("com.datajpa.example.repository")
public class PersistenceConfig {
    @Autowired
    private DataSourceConfig config;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setInitialSize(config.getInitialPoolSize());
        dataSource.setMaxActive(config.getMaxActive());
        return dataSource;
    }
}
