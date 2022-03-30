package com.check24.venkat.imdb.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private Long filmId;

    private String filmName;

    private String language;

    @OneToMany(mappedBy = "film")
    private Set<FilmRating> filmRatings;

    public Film(Long filmId){
        this.filmId = filmId;
    }
}
