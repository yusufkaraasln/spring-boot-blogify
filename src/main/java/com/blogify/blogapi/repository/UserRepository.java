package com.blogify.blogapi.repository;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, Integer> {

    Optional<User> findFirstByEmail(String email);

    Optional<User> findById(Integer id);


    User getUserByUsername(String username);


}


