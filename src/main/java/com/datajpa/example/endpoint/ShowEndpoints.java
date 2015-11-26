package com.datajpa.example.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 显示所有endpoint节点
 */
@Component
public class ShowEndpoints extends AbstractEndpoint<List<Endpoint>> {
    private List<Endpoint> endpoints;

    @Autowired
    public ShowEndpoints(List<Endpoint> endpoints) {
        super("showEndpoints");
        this.endpoints = endpoints;
    }

    @Override
    public List<Endpoint> invoke() {
        return this.endpoints;
    }
}
