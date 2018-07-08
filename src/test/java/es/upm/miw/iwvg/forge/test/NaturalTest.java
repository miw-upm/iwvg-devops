package es.upm.miw.iwvg.forge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NaturalTest {

    private Natural myClass;

    @BeforeEach
    void before() {
        myClass = new Natural(5);
    }

    @Test
    void testNatural() {
        assertEquals(5, myClass.getValue());
    }

    @Test
    void testDuplex() {
        assertEquals(10, myClass.duplex());
    }

}
