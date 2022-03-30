package com.check24.venkat.imdb.repository;

import com.check24.venkat.imdb.entity.FilmRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRatingRepository extends JpaRepository<FilmRating, Long> {


}
