package com.check24.venkat.imdb.service;

import com.check24.venkat.imdb.dto.FilmDto;

import java.util.List;

public interface FilmService {

    FilmDto addFilm(FilmDto filmDto);

    List<FilmDto> getAllFilms();

    List<FilmDto> getSearchedFilms(String filmName);
}
