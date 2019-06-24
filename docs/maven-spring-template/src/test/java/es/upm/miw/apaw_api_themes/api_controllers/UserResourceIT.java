package es.upm.miw.apaw_api_themes.api_controllers;

import es.upm.miw.apaw_api_themes.ApiTestConfig;
import es.upm.miw.apaw_api_themes.dtos.IdDto;
import es.upm.miw.apaw_api_themes.dtos.UserBasicDto;
import es.upm.miw.apaw_api_themes.dtos.UserCreationDto;
import es.upm.miw.apaw_api_themes.dtos.UserPatchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class UserResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick", "email", "country", "city", null);
        this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
    }

    @Test
    void testCreateUserException() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick-2", null, "country", null, "street");
        this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPatchUser() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick-3", "email", "country", "city", null);
        String id = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();

        UserPatchDto userPatchDto = new UserPatchDto("city", "newCity");
        this.webTestClient
                .patch().uri(UserResource.USERS + UserResource.ID_ID, id)
                .body(BodyInserters.fromObject(userPatchDto))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testReadUserNick() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick-4", "email", "country", "city", null);
        String id = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();
        UserBasicDto userBasicDto = this.webTestClient
                .get().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, userBasicDto.getId());
        assertEquals("nick-4", userBasicDto.getNick());
    }

    @Test
    void testPutNick() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick-5", "email", "country", "city", null);
        String id = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();
        UserBasicDto userBasicDto = new UserBasicDto();
        userBasicDto.setNick("newNick");
        this.webTestClient
                .put().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, id)
                .body(BodyInserters.fromObject(userBasicDto))
                .exchange()
                .expectStatus().isOk();
        userBasicDto = this.webTestClient
                .get().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, userBasicDto.getId());
        assertEquals("newNick", userBasicDto.getNick());
    }

    @Test
    void testPutNickNotFoundException() {
        UserCreationDto userCreationDto =
                new UserCreationDto("nick-5", "email", "country", "city", null);
        String id = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(userCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();
        this.webTestClient
                .put().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPutNickBadRequestException() {
        this.webTestClient
                .put().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testReadUserNickException() {
        this.webTestClient
                .get().uri(UserResource.USERS + UserResource.ID_ID + UserResource.NICK, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

}
