package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.entity.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {


    void deleteById(Integer id);
    User getUserByUsername(String username);

    Optional<User> findById(Integer id);


    void save(User user);


}
