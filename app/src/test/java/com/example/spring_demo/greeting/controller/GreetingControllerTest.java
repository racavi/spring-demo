package com.example.spring_demo.greeting.controller;

import com.example.spring_demo.greeting.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author Rafa Calvo (https://www.rafacalvo.com/)
 * @version 1.0
 * @since 23/02/2023
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(GreetingController.class)
class GreetingControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<Greeting> jsonGreetingResponse;

    @Test
    void getDefaultGreeting() throws Exception {
        // given
        Greeting expectedGreeting = new Greeting("Hello, World!");
        //when
        MockHttpServletResponse response = mvc.perform(get("/greeting")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(
                jsonGreetingResponse.write(
                        expectedGreeting
                ).getJson());
    }

    @Test
    void getCustomGreeting() throws Exception {
        // given
        Greeting expectedGreeting = new Greeting("Hello, John!");
        //when
        MockHttpServletResponse response = mvc.perform(get("/greeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", "John"))
                .andReturn().getResponse();
        // then
        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        then(response.getContentAsString()).isEqualTo(
                jsonGreetingResponse.write(
                        expectedGreeting
                ).getJson());
    }

}
