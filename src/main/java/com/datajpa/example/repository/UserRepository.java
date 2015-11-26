package com.datajpa.example.repository;

import com.datajpa.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value = "select * from user", nativeQuery = true)
    List<User> nativeQuery();

    @Query(value = "select id,name,age,address from user where id=:id", nativeQuery = true)
    User nativeQueryOne(@Param("id") Integer id);

    User findOneByName(String name);

}
