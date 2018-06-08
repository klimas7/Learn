package pl.klimas7.learn.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Parallel {
    public int[] generate() {
        int[] array = IntStream.range(0, 100).toArray();
        Arrays.parallelSetAll(array, i -> i % 10);
        return array;
    }
}
