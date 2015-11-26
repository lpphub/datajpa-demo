package com.datajpa.example.endpoint;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义endpoind， 可提供application信息，只需要实现Endpoint方法，id为访问url 如/server
 */
@Component
public class ServerEndpoint implements Endpoint<List<String>> {
    @Override
    public String getId() {
        return "server";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public List<String> invoke() {
        List<String> serverDetails = new ArrayList<>();
        try {
            serverDetails.add("Server IP Address : " + InetAddress.getLocalHost().getHostAddress());
            serverDetails.add("Server OS : " + System.getProperty("os.name").toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverDetails;
    }
}
