package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.UserDetails;

import java.util.Optional;

public interface UserDetailsService {

    void saveUserDetails(UserDetails userDetails);

    Optional<UserDetails> getUserDetailsByUserId(Integer id);

    void deleteUserDetailsByUserId(Integer id);
}
