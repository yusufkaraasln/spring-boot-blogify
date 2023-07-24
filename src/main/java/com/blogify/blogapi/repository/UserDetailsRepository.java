package com.blogify.blogapi.repository;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {


}
