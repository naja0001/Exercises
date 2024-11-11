package com.example.exercises.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ParticipantControllerIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void createParticipant() {
        webClient
                .post().uri("/participants")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
{
"firstName": "John",
"lastName": "Doe",
"gender": "Male",
"age": 18,
"club": "RUNNING_CLUB",
"discipline": null,
"result": null
}
""")
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.firstName").isEqualTo("John")
                .jsonPath("$.lastName").isEqualTo("Doe")
                .jsonPath("$.gender").isEqualTo("Male")
                .jsonPath("$.age").isEqualTo(18)
                .jsonPath("$.club").isEqualTo("RUNNING_CLUB")
                .jsonPath("$.discipline").isEmpty()  // Expecting null or not present
                .jsonPath("$.result").isEmpty();      // Expecting null or not present
    }
}
