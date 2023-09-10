package com.example.codereviewstudy.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.codereviewstudy.domain.model.User;
import com.example.codereviewstudy.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private UserService userService;



  @Test
  public void signupUserTest() throws Exception {
    User testUser = new User();
    testUser.setId(1L);
    testUser.setLoginId("test");
    testUser.setPassword("123");

    given(userService.signupUser(any()))
        .willReturn(testUser);

    Map<String, String> map = new HashMap<>();
    map.put("loginId", "test");
    map.put("password", "123");


    mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(map)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.userId").value(1))
        .andExpect(jsonPath("$.loginId").value("test"))
        .andDo(print());
  }

  @Test
  public void searchUserTest() throws Exception {

    User testUser = new User();
    testUser.setId(1L);
    testUser.setLoginId("test");
    testUser.setPassword("123");

    when(userService.searchUser(1))
        .thenReturn(testUser);

    mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}", 1L)
            .param("loginId", "test"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.loginId").value("test"))
        .andExpect(jsonPath("$.password").value("123"))
        .andDo(print());
  }
}