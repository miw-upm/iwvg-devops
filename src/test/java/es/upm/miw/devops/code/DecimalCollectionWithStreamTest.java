package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.within;

class DecimalCollectionWithStreamTest {
    private DecimalCollectionWithStream decimalCollectionWithStream;

    @BeforeEach
    void before() {
        this.decimalCollectionWithStream = new DecimalCollectionWithStream();
        this.decimalCollectionWithStream.add(2.0);
        this.decimalCollectionWithStream.add(-1.0);
        this.decimalCollectionWithStream.add(3.0);
        this.decimalCollectionWithStream.add(2.0);
    }

    @Test
    void testDecimalCollection() {
        DecimalCollection emptyCollection = new DecimalCollection();
        assertThat(emptyCollection.size())
                .isZero();
    }

    @Test
    void testAdd() {
        assertThat(this.decimalCollectionWithStream.size())
                .isEqualTo(4);
    }

    @Test
    void testSum() {
        assertThat(this.decimalCollectionWithStream.sum())
                .isCloseTo(6.0, within(1e-5));
    }

    @Test
    void testSumEvenValues() {
        assertThat(this.decimalCollectionWithStream.sumEvenValues())
                .isCloseTo(4.0, within(1e-5));
    }

    @Test
    void testSumIfEmpty() {
        assertThat(new DecimalCollectionWithStream().sum())
                .isNaN();
    }

    @Test
    void testMax() {
        assertThat(this.decimalCollectionWithStream.max())
                .isCloseTo(3.0, within(1e-5));
    }

    @Test
    void testMaxIfEmpty() {
        assertThat(new DecimalCollectionWithStream().max())
                .isNaN();
    }
}

