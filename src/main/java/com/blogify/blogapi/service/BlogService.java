package com.blogify.blogapi.service;

import com.blogify.blogapi.request.BlogRequest;
import com.blogify.blogapi.entity.Blog;
import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.repository.UserRepository;
import com.blogify.blogapi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogify.blogapi.repository.BlogRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public Result<Blog> postBlog(int id, BlogRequest blog) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            return new Result<>(false, "User not found", null);

        Blog newBlog = new Blog( blog.getTitle(), blog.getContent(),  user.get(), new Date(), new Date());


        blogRepository.save(newBlog);

        return new Result<>(true, "success", newBlog);





    }

}
