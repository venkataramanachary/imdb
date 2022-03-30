package com.check24.venkat.imdb.service.impl;

import com.check24.venkat.imdb.dto.FilmDto;
import com.check24.venkat.imdb.entity.Film;
import com.check24.venkat.imdb.entity.FilmAttributes;
import com.check24.venkat.imdb.repository.FilmRepository;
import com.check24.venkat.imdb.service.FilmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public FilmDto addFilm(FilmDto filmDto) {
        Film film = new Film();
        BeanUtils.copyProperties(filmDto,film);
        film = filmRepository.save(film);
        filmDto.setFilmId(film.getFilmId());
        return filmDto;
    }

    @Override
    public List<FilmDto> getAllFilms() {
        List<FilmDto> filmDtos = new ArrayList<>();
        List<FilmAttributes> films = filmRepository.findAllFilms();
        filmDtos = films.stream().map(film -> new FilmDto(film))
                .collect(Collectors.toList());
        return filmDtos;
    }

    @Override
    public List<FilmDto> getSearchedFilms(String filmName) {
        List<FilmDto> filmDtos = null;
        List<FilmAttributes> films = filmRepository.findSearchedFilm(filmName.toLowerCase(Locale.ROOT));
        filmDtos = films.stream().map(film -> new FilmDto(film))
                .collect(Collectors.toList());
        return filmDtos;
    }
}
