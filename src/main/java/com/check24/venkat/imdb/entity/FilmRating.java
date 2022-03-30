package com.check24.venkat.imdb.entity;

import com.check24.venkat.imdb.dto.FilmRatingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(FilmRatingId.class)
public class FilmRating {

    @Id
    @Column(name = "userId")
    private Long userId;

    @Id
    @Column(name = "filmId")
    private  Long filmId;

    @ManyToOne
    @JoinColumn(name = "filmId",insertable = false, updatable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "userId",insertable = false, updatable = false)
    private User user;

    @Min(1)
    @Max(5)
    private int rating;

    public FilmRating(FilmRatingDto filmRatingDto){

        this.filmId = filmRatingDto.getFilmId();
        this.userId = filmRatingDto.getUserId();
        this.film = new Film(filmRatingDto.getFilmId());
        this.user = new User(filmRatingDto.getUserId());
        this.rating = filmRatingDto.getRating();
    }

}
