package com.datajpa.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

// DataSourceConfig中必须加setter, getter方法，属性名和key对应
@ConfigurationProperties(prefix = "spring.db")
public class DataSourceConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int initialPoolSize = 30;
    private int maxActive = 100;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }
}
