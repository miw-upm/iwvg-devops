package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.stream.LongStream;

public class ParallelStream {

    public static void main(String[] args) {
        LogManager.getLogger(ParallelStream.class).info("PROCESSORS: {}", Runtime.getRuntime().availableProcessors());
        new ParallelStream().run();

    }

    private void sequentialRange(int n) {
        long time = System.nanoTime();
        long result = LongStream.range(0, n)
                .reduce(0, Long::sum);
        LogManager.getLogger(this.getClass()).info("SEQUENTIAL RANGE: Value: {}, Time (ms): {}", result, (System.nanoTime() - time) / 1000_000);
    }

    private void sequentialCollection(int n) {
        long time = System.nanoTime();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += array[i];
        }
        LogManager.getLogger(this.getClass()).info("SEQUENTIAL COLLECTION: Value: {}, Time (ms): {}", result, (System.nanoTime() - time) / 1000_000);
    }

    private void parallelRange(int n) {
        long time = System.nanoTime();
        long result = LongStream.range(0, n)
                .parallel()
                .reduce(0L, Long::sum);
        LogManager.getLogger(this.getClass()).info("PARALLEL RANGE: Value: {}, Time (ms): {}", result, (System.nanoTime() - time) / 1000_000);
    }

    private void parallelIterative(int n) {
        long time = System.nanoTime();
        long result = LongStream.iterate(0, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
        LogManager.getLogger(this.getClass()).info("PARALLEL ITERATIVE: Value: {}, Time (ms): {}", result, (System.nanoTime() - time) / 1000_000);
    }

    private void parallelArray(int n) {
        long[] array = LongStream.range(0, n).toArray();
        long time = System.nanoTime();
        long result = Arrays.stream(array)
                .parallel()
                .reduce(0L, Long::sum);
        LogManager.getLogger(this.getClass()).info("PARALLEL ARRAY: Value: {}, Time (ms): {}", result, (System.nanoTime() - time) / 1000_000);
    }

    private void run() {
        final int max = 100_000_000;
        for (int i = 0; i < 5; i++) {
            this.parallelRange(max);
        }
        for (int i = 0; i < 5; i++) {
            this.sequentialRange(max);
        }
        for (int i = 0; i < 5; i++) {
            this.parallelIterative(max);
        }
        for (int i = 0; i < 5; i++) {
            this.sequentialCollection(max);
        }
        for (int i = 0; i < 5; i++) {
            this.parallelArray(max);
        }
    }
}
