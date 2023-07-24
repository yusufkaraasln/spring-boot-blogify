package com.blogify.blogapi.dto;


import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.enums.UserType;
import lombok.Data;

import java.util.List;

@Data

public class UserDTO {

    private Integer id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private UserType userType;
    private List<UserDTO> followers;
    private List<UserDTO> following;


}
