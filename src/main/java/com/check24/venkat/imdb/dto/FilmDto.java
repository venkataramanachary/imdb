package com.check24.venkat.imdb.dto;

import com.check24.venkat.imdb.entity.Film;
import com.check24.venkat.imdb.entity.FilmAttributes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmDto {

    private Long filmId;

    private String filmName;

    private String language;

    private String rating;

    public FilmDto(Film film){
        this.filmId = film.getFilmId();
        this.filmName = film.getFilmName();
        this.language = film.getLanguage();
    }

    public FilmDto(FilmAttributes filmAttributes){
        this.filmId = Long.parseLong(filmAttributes.getFilmId());
        this.filmName = filmAttributes.getFilmName();
        this.language = filmAttributes.getLanguage();
        this.rating = filmAttributes.getAvgRating();
    }
}
