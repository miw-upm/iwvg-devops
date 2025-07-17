package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.within;

class DecimalCollectionTest {
    private DecimalCollection decimalCollection;

    @BeforeEach
    void before() {
        this.decimalCollection = new DecimalCollection();
        this.decimalCollection.add(2.0);
        this.decimalCollection.add(-1.0);
        this.decimalCollection.add(3.0);
        this.decimalCollection.add(2.0);
    }

    @Test
    void testDecimalCollection() {
        DecimalCollection emptyCollection = new DecimalCollection();
        assertThat(emptyCollection.size())
                .isZero();
    }

    @Test
    void testAdd() {
        assertThat(this.decimalCollection.size())
                .isEqualTo(4);
    }

    @Test
    void testSum() {
        assertThat(this.decimalCollection.sum())
                .isCloseTo(6.0, within(1e-5));
    }

    @Test
    void testSumEvenValues() {
        assertThat(this.decimalCollection.sumEvenValues())
                .isCloseTo(4.0, within(1e-5));
    }

    @Test
    void testSumIfEmpty() {
        assertThat(new DecimalCollection().sum())
                .isNaN();
    }

    @Test
    void testMax() {
        assertThat(this.decimalCollection.max())
                .isCloseTo(3.0, within(1e-5));
    }

    @Test
    void testMaxIfEmpty() {
        assertThat(new DecimalCollection().max())
                .isNaN();
    }

}
