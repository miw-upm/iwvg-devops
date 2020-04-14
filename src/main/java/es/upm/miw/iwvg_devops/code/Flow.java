package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flow {

    public long size(Stream<Integer> stream) {
        return stream.count();
    }

    public Integer[] toArray(Stream<Integer> stream) {
        return stream.toArray(Integer[]::new);
    }

    public List<Integer> toList(Stream<Integer> stream) {
        return stream.collect(Collectors.toList());
    }

    public double max(Stream<Integer> stream) {
        return stream.max(Integer::compareTo)
                .orElseThrow(ArithmeticException::new);  // Optional
    }

    public double sum(Stream<Integer> stream) {  //overage
        return stream.reduce(Integer::sum)
                .orElseThrow(ArithmeticException::new);   // Optional
    }

    public double mul(Stream<Integer> stream) {
        return stream.reduce(1, (accumulator, value) -> accumulator * value);
    }

    public Stream<String> mapToString(Stream<Integer> stream) {
        return stream.map(String::valueOf);
    }

    public Stream<Integer> increment(Stream<Integer> stream) {
        return stream.map(value -> value + 1);
    }

    public Double incrementAndSum(Stream<Integer> stream) {
        return stream
                .map(value -> value + 1)
                .mapToDouble(Double::valueOf)
                .reduce(Double::sum)
                .orElseThrow(ArithmeticException::new);
    }

    public Stream<Integer> filterPositives(Stream<Integer> stream) {
        return stream.filter(value -> value >= 0);
    }

    public Boolean isValueContent(Stream<Integer> stream, Integer value) {
        return stream.anyMatch(value::equals);
    }

    public Boolean areAllPositive(Stream<Integer> stream) {
        return stream.allMatch(value -> value >= 0);
    }

    public Stream<Integer> removeCopy(Stream<Integer> stream) {
        return stream.distinct();
    }

    public void log(Stream<Integer> stream) {
        stream.forEach(LogManager.getLogger(this.getClass())::info);
    }

    public Stream<Integer> flattening(Stream<Integer[]> stream) {
        return stream.flatMap(Stream::of);
    }
}
