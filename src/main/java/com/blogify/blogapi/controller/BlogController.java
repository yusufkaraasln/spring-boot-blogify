package com.blogify.blogapi.controller;

import com.blogify.blogapi.request.BlogRequest;
import com.blogify.blogapi.entity.Blog;
import com.blogify.blogapi.service.BlogService;
import com.blogify.blogapi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/{userId}")
    public Result<Blog> createBlog(@PathVariable int userId, @RequestBody BlogRequest blog) {
        return blogService.postBlog(userId, blog);
    }


}
