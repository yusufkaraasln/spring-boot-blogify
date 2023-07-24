package com.blogify.blogapi.entity;


import com.blogify.blogapi.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String name;

    private String surname;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;


    @JsonIgnore
    private String password;

    private UserType userType;

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)
    private List<Followers> followers;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private List<Followers> following;


}
