package com.blogify.blogapi.controller;

import com.blogify.blogapi.dto.UserDTO;
import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.repository.FollowersRepository;
import com.blogify.blogapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private  UserRepository userService;
    private FollowersRepository followersRepository;
    private ModelMapper modelMapper;



    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // User nesnesini UserDTO'ya dönüştür
        UserDTO userDTO = convertToUserDTO(user);

        return ResponseEntity.ok(userDTO);
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());


            List<UserDTO> followersDTO = user.getFollowers()
                    .stream()
                    .map(follower -> convertToUserDTOMinimal(follower.getFrom()))
                    .collect(Collectors.toList());
            userDTO.setFollowers(followersDTO);




            List<UserDTO> followingDTO = user.getFollowing()
                    .stream()
                    .map(follower -> convertToUserDTOMinimal(follower.getTo()))
                    .collect(Collectors.toList());
            userDTO.setFollowing(followingDTO);


        return userDTO;
    }


    private UserDTO convertToUserDTOMinimal(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }





}
