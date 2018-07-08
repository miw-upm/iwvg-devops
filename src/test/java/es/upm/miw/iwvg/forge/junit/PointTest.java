package es.upm.miw.iwvg.forge.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    private Point pt;

    @BeforeEach
    void before() {
        pt = new Point(2, 3);
    }

    @Test
    void testPuntoIntInt() {
        assertEquals(2, pt.getX());
        assertEquals(3, pt.getY());
    }
    
    @Test
    void testPuntoInt() {
        pt = new Point(2);
        assertEquals(2, pt.getX());
        assertEquals(2, pt.getY());
    }

    @Test
    void testPunto() {
        pt = new Point();
        assertEquals(0, pt.getX());
        assertEquals(0, pt.getY());
    }

    @Test
    void testModulo() {
        assertEquals(3.6055, pt.module(), 10e-5);
    }

    @Test
    void testFase() {
        assertEquals(0.9828, pt.phase(), 10e-5);
    }

    @Test
    void testTranslate() {
        this.pt.translateOrigin(new Point(1, 1));
        assertEquals(1, pt.getX());
        assertEquals(2, pt.getY());
    }

}
