package com.blogify.blogapi.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "from_user_fk")
    private User from;

    @ManyToOne
    @JoinColumn(name = "to_user_fk")
    private User to;


    public Followers(User from, User to) {
        this.from = from;
        this.to = to;
    }
}


