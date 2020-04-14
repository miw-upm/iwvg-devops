package es.upm.miw.iwvg_devops.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsersDatabaseSeeding {

    public Stream<User> findAll() {

        List<Fraction> fractions = Arrays.asList(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = Arrays.asList(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = Arrays.asList(
                new Fraction(1, 5),
                new Fraction(3, -6),
                new Fraction(1, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions4 = Arrays.asList(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = Arrays.asList(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = Arrays.asList(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }
}
