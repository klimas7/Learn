package pl.klimas7.learn.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

public class ParallelTest {

    @Test
    public void testGenerate() throws Exception {
        Parallel parallel = new Parallel();
        int[] ints = parallel.generate();
        System.out.println(IntStream.of(ints).parallel().sum());

        System.out.println(Arrays.toString(ints));

    }
}