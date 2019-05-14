package es.upm.miw.iwvg.ecosystem.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class AdminResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadInfo() {
        String body = this.webTestClient
                .get().uri(AdminResource.ADMINS)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
        assertEquals("Hello World!!!", body.substring(0, 14));

    }


}
