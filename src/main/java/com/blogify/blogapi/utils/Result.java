package com.blogify.blogapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Result<T> {
    private boolean success;
    private String message;
    private T data;
}


