package es.upm.miw.iwvg.forge.junit.exception; 

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.iwvg.forge.junit.exception.DecimalCollection;

public class DecimalCollectionTest {
    private DecimalCollection decimalCollection;

    @Before
    public void before() {
        this.decimalCollection = new DecimalCollection();
        this.decimalCollection.add(2.0);
        this.decimalCollection.add(-1.0);
        this.decimalCollection.add(3.0);
        this.decimalCollection.add(2.0);
    }

    @Test
    public void testDecimalCollection() {
        this.decimalCollection = new DecimalCollection();
        assertEquals(0, this.decimalCollection.size());
    }

    @Test
    public void testAdd() {
        assertEquals(4, this.decimalCollection.size());
    }

    @Test
    public void testSum() {
        assertEquals(6.0, this.decimalCollection.sum(), 10e-5);
    }

    @Test(expected = ArithmeticException.class)
    public void testSumArithmeticExceptionIfEmpty() {
        new DecimalCollection().sum();
    }

    @Test
    public void testHigher() {
        assertEquals(3.0, this.decimalCollection.higher(), 10e-5);
    }

    @Test(expected = ArithmeticException.class )
    public void testHigherArithmeticExceptionIfEmpty() {
        new DecimalCollection().higher();
    }

}
