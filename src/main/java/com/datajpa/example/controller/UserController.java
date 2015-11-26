package com.datajpa.example.controller;

import com.datajpa.example.entity.User;
import com.datajpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    @ResponseBody
    public User getOne(@PathVariable("id") Integer id) {
        System.out.println("测试：" + id);
        return userService.getOne(id);
    }
}
