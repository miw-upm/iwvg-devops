package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String name) {
        return new UsersDatabaseSeeding().findAll()
                .filter(user -> name.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findUserFractionNumeratorByFamilyName(String familyName) {
        return new UsersDatabaseSeeding().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> familyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findFamilyNameByFractionDenominator(int denominator) {
        return new UsersDatabaseSeeding().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> denominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

}
