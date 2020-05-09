package es.upm.miw.iwvg_devops.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BadgeTest {

    @Test
    void testGenerateBadge() {
        String badge = new Badge().generateBadge("Heroku", "v2.2.0-SNAPSHOT");
        assertNotNull(badge);
        assertEquals("<svg", badge.substring(0, 4));
    }
}
