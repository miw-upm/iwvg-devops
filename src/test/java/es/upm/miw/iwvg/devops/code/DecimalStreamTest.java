package es.upm.miw.iwvg.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalStreamTest {
    private DecimalStream decimalStream;

    @BeforeEach
    void before() {
        this.decimalStream = new DecimalStream();
        this.decimalStream.add(2.0);
        this.decimalStream.add(-1.0);
        this.decimalStream.add(3.0);
        this.decimalStream.add(2.0);
    }

    @Test
    void testDecimalCollection() {
        this.decimalStream = new DecimalStream();
        assertEquals(0, this.decimalStream.size());
    }

    @Test
    void testAdd() {
        assertEquals(4, this.decimalStream.size());
    }

    @Test
    void testSum() {
        assertEquals(6.0, this.decimalStream.sum(), 10e-5);
    }

    @Test
    void testSumEvenValues() {
        assertEquals(4.0, this.decimalStream.sumEvenValues(), 10e-5);
    }

    @Test
    void testSumIfEmpty() {
        assertEquals(Double.NaN, new DecimalStream().sum(), 10e-5);
    }

    @Test
    void testMax() {
        assertEquals(3.0, this.decimalStream.max(), 10e-5);
    }

    @Test
    void testMaxIfEmpty() {
        assertEquals(Double.NaN, new DecimalStream().max(), 10e-5);

    }
}

