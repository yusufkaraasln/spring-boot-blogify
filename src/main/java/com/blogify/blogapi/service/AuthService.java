package com.blogify.blogapi.service;

import com.blogify.blogapi.utils.Result;

import java.nio.file.AccessDeniedException;

public interface AuthService {

    Result<String> login(String email, String password) throws AccessDeniedException;

    Result<String> register(String email, String password
            , String name, String surname, String username
    ) throws AccessDeniedException;
}
