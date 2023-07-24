package com.blogify.blogapi.service;


import com.blogify.blogapi.entity.UserDetails;
import com.blogify.blogapi.repository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {


    UserDetailsRepository userDetailsRepository;



    @Override
    public void saveUserDetails(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public Optional<UserDetails> getUserDetailsByUserId(Integer id) {
        return userDetailsRepository.findById(id);
    }


    @Override
    public void deleteUserDetailsByUserId(Integer id) {
        userDetailsRepository.deleteById(id);
    }


}
