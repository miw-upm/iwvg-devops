package es.upm.miw.iwvg_devops.code;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        int max = 10000;
        Stream<String> streamSequential = Stream.generate(() -> "N" + new Random().nextInt()).limit(max);
        Stream<String> streamParallel = Stream.generate(() -> "N" + new Random().nextInt()).parallel().limit(max);
        long time1 = new Date().getTime();
        long cont1 = streamSequential.filter(value -> value.length() > 2).filter(value -> value.contains("23")).count();
        long time2 = new Date().getTime();
        long cont2 = streamParallel.filter(value -> value.length() > 2).filter(value -> value.contains("23")).count();
        long time3 = new Date().getTime();
        System.out.println("SEQUENTIAL... Count: " + cont1 + ", Time (ns): " + (time1 - time2));
        System.out.println("PARALLEL... Count: " + cont2 + ", Time (ns): " + (time2 - time3));

    }
}
