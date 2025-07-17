package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.within;

class DecimalStreamWithFunctionalProgrammingTest {

    private Stream<Double> stream;

    @BeforeEach
    void before() {
        this.stream = Stream.of(2.0, -1.0, 3.0, 2.0);
    }

    @Test
    void testSize() {
        long result = new DecimalStreamWithFunctionalProgramming().size(this.stream);
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void testSum() {
        double result = new DecimalStreamWithFunctionalProgramming().sum(Stream.of(2.0, -1.0, 3.0, 2.0));
        assertThat(result)
                .isCloseTo(6.0, within(1e-5));
    }

    @Test
    void testSumIfEmpty() {
        double result = new DecimalStreamWithFunctionalProgramming().sum(Stream.empty());
        assertThat(result)
                .isNaN();
    }

    @Test
    void testSumEvenValues() {
        double result = new DecimalStreamWithFunctionalProgramming().sumEvenValues(Stream.of(2.0, -1.0, 3.0, 2.0));
        assertThat(result)
                .isCloseTo(4.0, within(1e-5));
    }

    @Test
    void testMax() {
        double result = new DecimalStreamWithFunctionalProgramming().max(Stream.of(2.0, -1.0, 3.0, 2.0));
        assertThat(result)
                .isCloseTo(3.0, within(1e-5));
    }

    @Test
    void testMaxIfEmpty() {
        double result = new DecimalStreamWithFunctionalProgramming().max(Stream.empty());
        assertThat(result)
                .isNaN();
    }
}
