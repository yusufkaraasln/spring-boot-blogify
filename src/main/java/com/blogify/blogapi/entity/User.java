package com.blogify.blogapi.entity;


import com.blogify.blogapi.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Blog> blogs;


    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Followers> followers;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Followers> following;


}
