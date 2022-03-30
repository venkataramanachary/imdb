package com.check24.venkat.imdb.service.impl;

import com.check24.venkat.imdb.dto.FilmRatingDto;
import com.check24.venkat.imdb.entity.FilmRating;
import com.check24.venkat.imdb.repository.FilmRatingRepository;
import com.check24.venkat.imdb.service.FilmRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmRatingServiceImpl implements FilmRatingService {

    @Autowired
    FilmRatingRepository filmRatingRepository;

    @Override
    public FilmRatingDto saveFilmRating(FilmRatingDto filmRatingDto) {
        FilmRating filmRating = new FilmRating(filmRatingDto);
        filmRating = filmRatingRepository.save(filmRating);
        return filmRatingDto;
    }

}
