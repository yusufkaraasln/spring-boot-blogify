package com.blogify.blogapi.repository;

import com.blogify.blogapi.entity.Followers;
import com.blogify.blogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Integer> {
    Followers findByFromAndTo(User from, User to);
    List<User> findAllByFrom(User from);
    List<User> findAllByTo(User to);


}