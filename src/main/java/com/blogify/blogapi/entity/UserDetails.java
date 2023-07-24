package com.blogify.blogapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor


public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String bio;

    private String profilePic;

    private String age;

    public UserDetails(String bio, String profilePic, String age) {
        this.bio = bio;
        this.profilePic = profilePic;
        this.age = age;
    }



}
