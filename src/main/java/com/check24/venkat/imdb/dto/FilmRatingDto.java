package com.check24.venkat.imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmRatingDto {

    private Long filmId;

    private Long userId;

    private String filmName;

    private String userFullName;

    @Min(1)
    @Max(5)
    private int rating;
}
