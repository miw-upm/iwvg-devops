package es.upm.miw.iwvg.forge.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceIT {

    @Test
    void test() {
        Service service = new Service();
        assertNotNull(service.getValue());
    }

}
