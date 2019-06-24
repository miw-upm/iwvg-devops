package es.upm.miw.apaw_api_themes.api_controllers;

import es.upm.miw.apaw_api_themes.ApiTestConfig;
import es.upm.miw.apaw_api_themes.dtos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class ThemeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    private String themeId;

    @BeforeEach
    void before() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick3", "email", "country", "city", null);
        String userId = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();
        ThemeCreationDto themeCreationDto =
                new ThemeCreationDto("theme-1", userId);
        this.themeId = this.webTestClient
                .post().uri(ThemeResource.THEMES)
                .body(BodyInserters.fromObject(themeCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();
    }

    @Test
    void testCreateVotesAndOverage() {
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, this.themeId)
                .body(BodyInserters.fromObject(new VoteDto(2)))
                .exchange()
                .expectStatus().isOk();
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, this.themeId)
                .body(BodyInserters.fromObject(new VoteDto(3)))
                .exchange()
                .expectStatus().isOk();
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, this.themeId)
                .body(BodyInserters.fromObject(new VoteDto(4)))
                .exchange()
                .expectStatus().isOk();
        Double average = this.webTestClient
                .get().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.AVERAGE, this.themeId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AverageDto.class)
                .returnResult().getResponseBody().getAverage();
        assertEquals(3, average, 10e-5);
    }

    @Test
    void testSearch() {
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, this.themeId)
                .body(BodyInserters.fromObject(new VoteDto(9)))
                .exchange()
                .expectStatus().isOk();
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, this.themeId)
                .body(BodyInserters.fromObject(new VoteDto(9)))
                .exchange()
                .expectStatus().isOk();
        List<ThemeBasicDto> themes = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(ThemeResource.THEMES + ThemeResource.SEARCH)
                                .queryParam("q", "average:>=9")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ThemeBasicDto.class)
                .returnResult().getResponseBody();
        assertFalse(themes.isEmpty());
    }

    @Test
    void testAverageNoVotes() {
        Double overage = this.webTestClient
                .get().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.AVERAGE, this.themeId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AverageDto.class)
                .returnResult().getResponseBody().getAverage();
        assertTrue(Double.isNaN(overage));
    }

    @Test
    void testAverageNotFoundException() {
        this.webTestClient
                .get().uri(ThemeResource.THEMES + "no" + ThemeResource.AVERAGE, this.themeId)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreateVoteNotFoundException() {
        VoteDto voteDto = new VoteDto(5);
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, "no")
                .body(BodyInserters.fromObject(voteDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreateVoteBadRequestException() {
        VoteDto voteDto = new VoteDto();
        this.webTestClient
                .post().uri(ThemeResource.THEMES + ThemeResource.ID_ID + ThemeResource.VOTES, "no")
                .body(BodyInserters.fromObject(voteDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
