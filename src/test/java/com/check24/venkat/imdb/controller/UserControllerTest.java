package com.check24.venkat.imdb.controller;

import com.check24.venkat.imdb.controllers.UserController;
import com.check24.venkat.imdb.dto.UserDto;
import com.check24.venkat.imdb.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void saveUser() throws Exception{
        UserDto userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setUsername("venkat");
        userDto.setPassword("venkat");
        userDto.setFirstName("venkat");
        userDto.setLastName("S");
        userDto.setEmail("venkat@gmail.com");
        final ResponseEntity<UserDto> expectedResult = ResponseEntity.ok(userDto);

        Mockito.when(userService.createUser(userDto)).thenReturn(userDto);

        MvcResult result = mockMvc.perform(post("/userref/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


        Assert.assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    public void login() throws Exception{
        UserDto userDto = new UserDto();

        userDto.setUsername("venkat");
        userDto.setPassword("venkat");

        final ResponseEntity<UserDto> expectedResult = ResponseEntity.ok(userDto);

        Mockito.when(userService.createUser(userDto)).thenReturn(userDto);

        MvcResult result = mockMvc.perform(post("/userref/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


        Assert.assertEquals(result.getResponse().getStatus(), 200);
    }

    public static String asJsonString(final Object obj){
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonContent = objectMapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
