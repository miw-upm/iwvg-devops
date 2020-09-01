package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findUserFractionNumeratorByFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> familyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findFamilyNameByFractionDenominator(int denominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> denominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return null;
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return null;
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return null;
    }

    public Fraction findFirstFractionDivisionByUserId(String id) {
        return null;
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return null;
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return null;
    }


    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return null;
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return null;
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return null;
    }

    public Fraction findHighestFraction() {
        return null;
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return null;
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return null;
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return null;
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return null;
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return null;
    }

}
