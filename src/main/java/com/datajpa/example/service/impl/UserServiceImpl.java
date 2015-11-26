package com.datajpa.example.service.impl;

import com.datajpa.example.entity.User;
import com.datajpa.example.dao.UserDao;
import com.datajpa.example.repository.UserRepository;
import com.datajpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDao userDao;

    @Override
    public User getOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> nativeQuery() {
        return userRepository.nativeQuery();
    }

    @Override
    public User findOneByName(String name) {
        return userRepository.findOneByName(name);
    }

    @Override
    public User nativeQueryOne(Integer id) {
        return userRepository.nativeQueryOne(id);
    }

    @Override
    public List<User> query(String name, Integer age) {
        return userRepository.findAll((root, query, cb) -> {
            query.where(cb.equal(root.get("name"), name), cb.equal(root.get("age"), age));
            return null;
        });

//        return userRepository.findAll(new Specification<User>() {
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                query.where(cb.equal(root.get("name"), name), cb.equal(root.get("age"), age));
//                return null;
//            }
//        });
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllByCustom() {
        return userDao.findAll();
    }
}
