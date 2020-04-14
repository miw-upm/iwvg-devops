package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(Arrays.asList("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(Arrays.asList(2, 4, 0, 1, 1), new Searches().findUserFractionNumeratorByFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(Arrays.asList("López", "Torres"), new Searches().findFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }

    void testFindUserIdByAnyProperFraction() {
    }

    void testFindUserNameByAnyImproperFraction() {
    }

    void testFindUserFamilyNameByAllSignFractionDistinct() {
    }

    void testFindDecimalFractionByUserName() {
    }

    void testFindDecimalFractionBySignFraction() {
    }

    void testFindFractionAdditionByUserId() {
    }

    void testFindFractionSubtractionByUserName() {
    }

    void testFindFractionMultiplicationByUserFamilyName() {
    }
}
