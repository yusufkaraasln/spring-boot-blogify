package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.entity.UserDetails;
import com.blogify.blogapi.repository.UserDetailsRepository;
import com.blogify.blogapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    UserRepository userRepository;


    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);


    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);


    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }




}
