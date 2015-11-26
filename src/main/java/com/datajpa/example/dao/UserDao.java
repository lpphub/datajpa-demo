package com.datajpa.example.dao;

import com.datajpa.example.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
