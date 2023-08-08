package com.blogify.blogapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Entity
@Table(name = "followers")
@NoArgsConstructor
@Getter
@Setter
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "from_user_fk")
    @JsonBackReference
    private User from;

    @ManyToOne
    @JoinColumn(name = "to_user_fk")
    @JsonBackReference
    private User to;


    public Followers(User from, User to) {
        this.from = from;
        this.to = to;
    }
}


