package es.upm.miw.iwvg.devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.function.*;


public class Lambda {

    public static Consumer<String> logInfo = // accept(T)
            LogManager.getLogger(Lambda.class)::info;

    public static Consumer<String> logInfoDetail = // accept(T)
            msg -> LogManager.getLogger(Lambda.class).info("Consumer: {}", msg);

    public static Function<String, Integer> convertToInt = // apply(T):R
            Integer::parseInt; //return implicit

    public static Function<String, Integer> convertToIntPlus1 = // apply(T):R
            value -> Integer.parseInt(value) + 1; //return implicit

    public static Function<String, Integer> convertToIntZeroTo1 = // apply(T):R
            value -> {
                if ("0".equals(value)) {
                    return 1;
                } else {
                    return Integer.parseInt(value);
                }
            };

    public static Predicate<String> equalsTo2 = // test(T):boolean
            "two"::equals;

    public static Supplier<String> generateDots = // get(): T
            () -> "...";

    public static BiConsumer<String, String> biLogInfo =  // apply(T,U):R
            (msg1, msg2) -> LogManager.getLogger(Lambda.class).info("Bi-Consumer: {}, {}", msg1, msg2);

    public static BiFunction<Integer, Integer, Integer> multiply =  // accept(T,U):R
            (x, y) -> x * y;

    public static BiPredicate<String, String> compare =  // apply(T,U):R
            String::equals;
}
