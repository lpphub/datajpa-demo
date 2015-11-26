package com.datajpa.example.service;

import com.datajpa.example.entity.User;

import java.util.List;

public interface UserService {
    User getOne(Integer id);

    User findOneByName(String name);

    List<User> findAll();

    List<User> nativeQuery();

    User nativeQueryOne(Integer id);

    List<User> query(String name, Integer age);

    User save(User user);

    List<User> findAllByCustom();
}
