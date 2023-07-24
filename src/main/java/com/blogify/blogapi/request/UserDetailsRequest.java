package com.blogify.blogapi.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsRequest {


    private String bio;

    private String profilePic;

    private String age;


}
