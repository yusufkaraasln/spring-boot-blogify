package com.blogify.blogapi.controller;

import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.repository.UserRepository;
import com.blogify.blogapi.request.FollowRequest;
import com.blogify.blogapi.service.FollowersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class FollowController {

    private final FollowersService followersService;
    private UserRepository userService;




    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestBody FollowRequest followRequest) {
        Optional<User> fromUser = userService.findById(followRequest.getFromUserId());
        Optional<User> toUser = userService.findById(followRequest.getToUserId());

        User fromUser1 = fromUser.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        User toUser1 = toUser.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));



        followersService.follow(fromUser1, toUser1);

        return ResponseEntity.ok("Takip işlemi başarılı");
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<String> unfollowUser(@RequestBody FollowRequest followRequest) {
        Optional<User> fromUser = userService.findById(followRequest.getFromUserId());
        Optional<User> toUser = userService.findById(followRequest.getToUserId());

        User fromUser1 = fromUser.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        User toUser1 = toUser.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        followersService.unfollow(fromUser1, toUser1);

        return ResponseEntity.ok("Takipçi çıkarma işlemi başarılı");
    }
}