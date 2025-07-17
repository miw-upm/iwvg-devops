package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


class LambdaTest {

    @Test
    void testConsumers() {
        assertThatCode(() -> Stream.of("one", "two", "three").forEach(Lambda.logInfo))
                .doesNotThrowAnyException();
        assertThatCode(() -> Stream.of("one", "two", "three").forEach(Lambda.logInfoDetail))
                .doesNotThrowAnyException();
    }

    @Test
    void testFunctionConvertToInt() {
        List<Integer> list = Stream.of("1", "2", "3").map(Lambda.convertToInt).toList();
        assertThat(list).containsExactly(1, 2, 3);
    }

    @Test
    void testFunctionConvertToPlus1() {
        List<Integer> list = Stream.of("1", "2", "3").map(Lambda.convertToIntPlus1).toList();
        assertThat(list).containsExactly(2, 3, 4);
    }

    @Test
    void testFunctionConvertToIntZeroTo1() {
        List<Integer> list = Stream.of("0", "1", "2").map(Lambda.convertToIntZeroTo1).toList();
        assertThat(list).containsExactly(1, 1, 2);
    }

    @Test
    void testPredicate() {
        List<String> list = Stream.of("one", "two", "three", "two").filter(Lambda.equalsTo2).toList();
        assertThat(list).containsExactly("two", "two");
    }

    @Test
    void testSupplier() {
        List<String> list = Stream.generate(Lambda.generateDots).limit(3).toList();
        assertThat(list).containsExactly("...", "...", "...");
    }

}

