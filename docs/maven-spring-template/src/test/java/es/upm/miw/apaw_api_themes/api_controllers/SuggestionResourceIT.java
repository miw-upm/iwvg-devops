package es.upm.miw.apaw_api_themes.api_controllers;

import es.upm.miw.apaw_api_themes.ApiTestConfig;
import es.upm.miw.apaw_api_themes.dtos.SuggestionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
class SuggestionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateAndReadAll() {
        SuggestionDto suggestionDto = new SuggestionDto(false, "Sugerencia... ");
        this.webTestClient
                .post().uri(SuggestionResource.SUGGESTIONS)
                .body(BodyInserters.fromObject(suggestionDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
        this.webTestClient
                .get().uri(SuggestionResource.SUGGESTIONS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SuggestionDto.class);
    }

    @Test
    void testCreateSuggestionException() {
        SuggestionDto suggestionDto = new SuggestionDto(false, null);
        this.webTestClient
                .post().uri(SuggestionResource.SUGGESTIONS)
                .body(BodyInserters.fromObject(suggestionDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
