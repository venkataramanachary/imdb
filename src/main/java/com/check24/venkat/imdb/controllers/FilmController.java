package com.check24.venkat.imdb.controllers;

import com.check24.venkat.imdb.dto.FilmDto;
import com.check24.venkat.imdb.entity.Film;
import com.check24.venkat.imdb.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping(value = "/addFilm")
    public ResponseEntity<FilmDto> addFilm(@RequestBody FilmDto filmDto){
        return new ResponseEntity<>(filmService.addFilm(filmDto), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllFilms")
    public ResponseEntity<List<FilmDto>> getAllFilms(){
        return new ResponseEntity<>(filmService.getAllFilms(), HttpStatus.OK);
    }

    @GetMapping(value = "/getSearchFilms")
    public ResponseEntity<List<FilmDto>> getSearchedFilms(@RequestParam String filmName){
        return new ResponseEntity<>(filmService.getSearchedFilms(filmName), HttpStatus.OK);
    }
}
