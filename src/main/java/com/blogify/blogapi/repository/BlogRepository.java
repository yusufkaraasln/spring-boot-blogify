package com.blogify.blogapi.repository;

import com.blogify.blogapi.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  BlogRepository extends JpaRepository<Blog, Integer> {

     /*List<Blog> findByUserId(int id);*//**/
}
