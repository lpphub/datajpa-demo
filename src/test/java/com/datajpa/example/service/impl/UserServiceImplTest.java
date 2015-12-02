package com.datajpa.example.service.impl;

import com.datajpa.example.Application;
import com.datajpa.example.entity.User;
import com.datajpa.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetOne() throws Exception {
        User user = userService.getOne(4);
        User user2 = userService.nativeQueryOne(1);
        System.out.println(user.getName() + "," + user.getAge() + "," + user.getAddress());
        System.out.println(user2.getName() + "," + user2.getAge() + "," + user2.getAddress());

        User user3 = userService.findOneByName("dgf");
        System.out.println(user3.getName() + "," + user3.getAge() + "," + user3.getAddress());

        List<User> user4 = userService.query("abc", 10);
        System.out.println(user4.size());

    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users1 = userService.findAll();
        System.out.println(users1.size());
        List<User> users2 = userService.nativeQuery();
        System.out.println(users2.size());
        List<User> users3 = userService.findAllByCustom();
        System.out.println(users3.size());
//        User user = new User();
//        user.setName("小张");
//        user.setAge(20);
//        user.setAddress("上海");
//        userService.save(user);
    }
}