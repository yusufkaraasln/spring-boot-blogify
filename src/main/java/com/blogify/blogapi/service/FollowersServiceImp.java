package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.Followers;
import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.repository.FollowersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowersServiceImp implements FollowersService {

    private  FollowersRepository followersRepository;



    public void follow(User fromUser, User toUser) {
        Followers followers = new Followers(fromUser, toUser);
        followersRepository.save(followers);
    }

    @Transactional
    public void unfollow(User fromUser, User toUser) {
        Followers followers = followersRepository.findByFromAndTo(fromUser, toUser);
        if (followers != null) {
            followersRepository.delete(followers);
        }
    }
}
