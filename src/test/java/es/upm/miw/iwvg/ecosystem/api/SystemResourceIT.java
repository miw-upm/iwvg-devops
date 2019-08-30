package es.upm.miw.iwvg.ecosystem.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestPropertySource(locations = "classpath:test.properties")
class SystemResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadBadge() {
        byte[] badge =
                this.webTestClient
                        .get().uri(SystemResource.SYSTEM + SystemResource.VERSION_BADGE)
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody(byte[].class)
                        .returnResult().getResponseBody();
        assertNotNull(badge);
        assertEquals("<svg", new String(badge).substring(0, 4));
    }

    @Test
    void testReadInfo() {
        String body = this.webTestClient
                .get().uri(SystemResource.SYSTEM + SystemResource.VERSION)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
        assertEquals(3, body.split("::").length);
    }
}
