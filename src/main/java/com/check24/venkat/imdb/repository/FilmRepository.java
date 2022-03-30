package com.check24.venkat.imdb.repository;

import com.check24.venkat.imdb.entity.Film;
import com.check24.venkat.imdb.entity.FilmAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "from Film fl where fl.filmName=:filmName")
    Optional<Film> findSearchedFilms(@Param("filmName") String filmName);

    @Query(value = "SELECT F.FILM_ID AS filmId, F.FILM_NAME AS filmName, F.LANGUAGE AS language, \n" +
            " ROUND(AVG(CAST(FR.RATING AS DECIMAL)),1)  AS avgRating FROM FILM F\n" +
            "LEFT JOIN FILM_RATING FR\n" +
            "ON FR.FILM_ID  = F.FILM_ID\n" +
            "WHERE LOWER(F.FILM_NAME) LIKE '%' || :filmName || '%' GROUP BY F.FILM_ID ORDER BY avgRating DESC", nativeQuery = true)
    List<FilmAttributes> findSearchedFilm(@Param("filmName") String filmName);


    @Query(value = "SELECT F.FILM_ID AS filmId, F.FILM_NAME AS filmName, F.LANGUAGE AS language,\n" +
            "     ROUND(AVG(CAST(FR.RATING AS DECIMAL)),1)  AS avgRating  FROM FILM F\n" +
            "LEFT JOIN FILM_RATING FR\n" +
            "ON FR.FILM_ID  = F.FILM_ID\n" +
            "GROUP BY F.FILM_ID ORDER BY avgRating DESC", nativeQuery = true)
   List<FilmAttributes> findAllFilms();



}
