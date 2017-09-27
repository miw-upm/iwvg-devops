package es.upm.miw.iwvg.forge.test;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import es.upm.miw.iwvg.forge.test.Service;

public class ServiceIT {

    @Test
    public void test() {
        Service service = new Service();
        assertNotNull(service.getValue());
    }

}
