package com.check24.venkat.imdb.controllers;

import com.check24.venkat.imdb.dto.FilmRatingDto;
import com.check24.venkat.imdb.service.FilmRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/filmrating")
public class FilmRatingController {

    @Autowired
    FilmRatingService filmRatingService;

    @PostMapping(value = "/saveFilmRating")
    public ResponseEntity<FilmRatingDto> saveFilmRating(@RequestBody FilmRatingDto filmRatingDto) {
        return new ResponseEntity<>(filmRatingService.saveFilmRating(filmRatingDto), HttpStatus.OK);
    }

}
