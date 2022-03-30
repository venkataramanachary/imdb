package com.check24.venkat.imdb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<FilmRating> ratings;

    public User(Long userId){
        this.userId = userId;
    }
}
