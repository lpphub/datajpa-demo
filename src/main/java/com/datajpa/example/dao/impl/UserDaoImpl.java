package com.datajpa.example.dao.impl;

import com.datajpa.example.dao.UserDao;
import com.datajpa.example.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("select u from User u");
        return query.getResultList();
    }
}
