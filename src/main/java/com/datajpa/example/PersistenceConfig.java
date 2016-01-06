package com.datajpa.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableConfigurationProperties(DataSourceConfig.class)
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

//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(dataSource)
//                .packages("com.datajpa.example.repository")
//                .build();
//    }
//
//    @Bean(name = "transactionManager")
//    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
//    }
}
