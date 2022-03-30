package com.check24.venkat.imdb.repository;

import com.check24.venkat.imdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User us where us.username=:userName")
    Optional<User> findByUserName(@Param("userName") String userName);
}
