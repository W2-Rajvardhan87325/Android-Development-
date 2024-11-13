package com.sunbeam.mobilesapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.mobilesapp.daos.UserDao;
import com.sunbeam.mobilesapp.entities.User;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User saveUser(User u) {
        return userDao.save(u);
    }

    public User findUserById(int id) {
        Optional<User> ou = userDao.findById(id);
        return ou.isPresent() ? ou.get() : null;
    }

    public User findUserByEmail(String email) {
        User du = userDao.findByEmail(email);
        return du;
    }

    public User findUserByEmailAndPassword(String email, String passwd) {
        User du = userDao.findByEmail(email);
        if(du != null && passwd.equals(du.getPassword()))
            return du;
        return null;
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public int deleteUserById(int id) {
        if(userDao.existsById(id)) {
            userDao.deleteById(id);
            return 1;
        }
        return 0;
    }
}
