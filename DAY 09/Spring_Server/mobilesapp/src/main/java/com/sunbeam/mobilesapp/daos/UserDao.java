package com.sunbeam.mobilesapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.mobilesapp.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
