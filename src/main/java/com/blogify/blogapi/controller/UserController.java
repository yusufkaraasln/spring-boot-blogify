package com.blogify.blogapi.controller;

import com.blogify.blogapi.dto.UserDTO;
import com.blogify.blogapi.entity.User;
import com.blogify.blogapi.entity.UserDetails;
import com.blogify.blogapi.repository.FollowersRepository;
import com.blogify.blogapi.repository.UserDetailsRepository;
import com.blogify.blogapi.repository.UserRepository;
import com.blogify.blogapi.request.UserDetailsRequest;
import com.blogify.blogapi.service.UserDetailsService;
import com.blogify.blogapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserDetailsService userDetailsService;
    private ModelMapper modelMapper;


    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        User user = userService.findById(id).orElse(null);

        userService.deleteById(user.getId());
        userDetailsService.deleteUserDetailsByUserId(user.getId());
        System.out.println("User deleted successfully");

        return ResponseEntity.ok("User deleted successfully");

    }


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


    @PutMapping("/details/{username}")

    public ResponseEntity<String>
    updateUserDetails(@PathVariable String username, @RequestBody UserDetailsRequest body) {

        User user = userService.getUserByUsername(username);

        UserDetails userDetails = modelMapper.map(body, UserDetails.class);

        userDetails.setId(user.getId());


        userDetailsService.saveUserDetails(userDetails);

        return ResponseEntity.ok("User details updated successfully");

    }


    private UserDTO convertToUserDTO(User user) {

        userDetailsService.getUserDetailsByUserId(user.getId()).ifPresent(userDetails -> user.setUserDetails(userDetails));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        userDTO.setUserDetails(user.getUserDetails());


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
