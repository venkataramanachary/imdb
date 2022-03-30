package com.check24.venkat.imdb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String email;
}
