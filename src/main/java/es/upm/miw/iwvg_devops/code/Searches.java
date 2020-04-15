package es.upm.miw.iwvg_devops.code;

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
                .peek(x -> System.out.println("before: " + x))
                .filter(user -> familyName.equals(user.getFamilyName()))
                .peek(x -> System.out.println("after: " + x))
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
