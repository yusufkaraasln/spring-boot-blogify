package com.blogify.blogapi.service;

import com.blogify.blogapi.entity.User;

public interface FollowersService {

    public void follow(User fromUser, User toUser);

    public void unfollow(User fromUser, User toUser);
}
