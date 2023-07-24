package com.blogify.blogapi.controller;

import com.blogify.blogapi.request.LoginRequest;
import com.blogify.blogapi.request.RegisterRequest;
import com.blogify.blogapi.service.AuthService;
import com.blogify.blogapi.utils.Result;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {


    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest body) throws AccessDeniedException {
        Result<String> result = authService.login(body.getEmail(), body.getPassword());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest body) throws AccessDeniedException {
        Result<String> result = authService.register(body.getEmail(), body.getPassword(), body.getName(), body.getSurname(), body.getUsername());
        return ResponseEntity.ok(result);
    }

}
