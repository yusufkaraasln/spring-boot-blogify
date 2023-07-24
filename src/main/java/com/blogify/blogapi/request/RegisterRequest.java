package com.blogify.blogapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

}