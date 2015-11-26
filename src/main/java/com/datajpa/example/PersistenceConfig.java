package com.datajpa.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@EnableConfigurationProperties(DataSourceConfig.class)
// 该注解是把application.properties中的配置映射到DataSourceConfig类中,
// DataSourceConfig用@ConfigurationProperties(prefix = "spring.data.mongodb")注解key-value
// DataSourceConfig中必须加setter, getter方法，属性名和key对应

@Configuration
@EntityScan("com.datajpa.example.entity")
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
public class PersistenceConfig {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("com.datajpa.example.repository")
                .build();
    }

    @Bean(name = "transactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }
}
