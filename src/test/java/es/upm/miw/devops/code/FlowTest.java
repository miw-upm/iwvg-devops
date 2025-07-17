package es.upm.miw.devops.code;



import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class FlowTest {

    @Test
    void testStreamFromList() {
        assertThat(new Flow().streamFromList().count())
                .isEqualTo(3);
    }

    @Test
    void testStreamFromRange() {
        assertThat(new Flow().streamFromRange().count())
                .isEqualTo(4); // 0..3
    }

    @Test
    void testStreamFromOf() {
        assertThat(new Flow().streamFromOf().count())
                .isEqualTo(3);
    }

    @Test
    void testStreamFromGenerate() {
        assertThat(new Flow().streamFromGenerate(7).count())
                .isEqualTo(7);
    }

    @Test
    void testStreamFromIterate() {
        assertThat(new Flow().streamFromIterate(7).count())
                .isEqualTo(7);
    }

    @Test
    void testToList() {
        assertThat(new Flow().toList(Stream.of(-3, 4, 0, -2, 5)))
                .containsExactly(-3, 4, 0, -2, 5);
    }

    @Test
    void testToArray() {
        assertThat(new Flow().toArray(Stream.of(0, 1)))
                .containsExactly(0, 1);
    }

    @Test
    void testFilterPositive() {
        Stream<Integer> stream = Stream.of(-2, 1, 0, -3, 3);
        assertThat(new Flow().filterPositives(stream).toList())
                .containsExactly(1, 0, 3);
    }

    @Test
    void testSkipFirst() {
        assertThat(new Flow().skipFirst(Stream.of(0, 1)).count())
                .isEqualTo(1);
    }

    @Test
    void shouldCalculateSize() {
        Stream<Integer> stream = Stream.of(0, 1);
        assertThat(new Flow().size(stream))
                .isEqualTo(2);
    }

    @Test
    void testRemoveDuplicates() {
        Stream<Integer> stream = Stream.of(0, 1, 0, 2, 2, 0);
        assertThat(new Flow().removeCopy(stream).toList())
                .containsExactly(0, 1, 2);
    }

    @Test
    void shouldNotThrowOnDebug() {
        // This test just runs without exception, no assertions needed
        assertThatCode(() -> new Flow().debug(Stream.of("0", "1")))
                .doesNotThrowAnyException();
    }

    @Test
    void testMapToString() {
        assertThat(new Flow().mapToString(Stream.of(3, 7)).toList())
                .containsExactly("3", "7");
    }

    @Test
    void testIncrement() {
        assertThat(new Flow().increment(Stream.of(3, 7)).toList())
                .containsExactly(4, 8);
    }

    @Test
    void testFlatten() {
        Integer[] array1 = {0, 1};
        Integer[] array2 = {0, 3};
        Integer[] array3 = {2, 5};
        assertThat(new Flow().flatten(Stream.of(array1, array2, array3)).toList())
                .containsExactly(0, 1, 0, 3, 2, 5);
    }

    @Test
    void testSum() {
        assertThat(new Flow().sum(Stream.of(-3, 4, 0, -2, 5)))
                .isEqualTo(4);
    }

    @Test
    void testMax() {
        assertThat(new Flow().max(Stream.of(-3, 4, 0, -2, 5)))
                .isEqualTo(5);
    }

    @Test
    void testMul() {
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1).limit(5);
        assertThat(new Flow().mul(stream))
                .isEqualTo(120);
    }

    @Test
    void testIncrementAndSum() {
        assertThat(new Flow().incrementAndSum(Stream.of(3, 7)))
                .isCloseTo(12.0, within(1e-5));
    }

    @Test
    void testTerminal() {
        assertThatCode(() -> new Flow().terminal(Stream.of(-2, 1, 0, -3, 3)))
                .doesNotThrowAnyException();
    }

    @Test
    void testIsValueContent() {
        Stream<Integer> stream = Stream.of(-2, 1, 0, -3, 3);
        assertThat(new Flow().isValueContent(stream, -3))
                .isTrue();
    }

    @Test
    void testIsValueContentNotExist() {
        Stream<Integer> stream = Stream.of(-2, 1, 0, -3, 3);
        assertThat(new Flow().isValueContent(stream, 4))
                .isFalse();
    }

    @Test
    void testAreAllPositive() {
        Stream<Integer> stream = Stream.of(1, 0, 3);
        assertThat(new Flow().areAllPositive(stream))
                .isTrue();
    }

    @Test
    void testAreAllPositiveExistNegative() {
        Stream<Integer> stream = Stream.of(-2, 1, 0, -3, 3);
        assertThat(new Flow().areAllPositive(stream))
                .isFalse();
    }
}
