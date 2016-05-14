package pl.sii.puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamRiddle {
    public static void main(String[] args) {
        Supplier<IntStream> supplierIntStream = () -> IntStream.rangeClosed(1, 256);

        List<Integer> ints = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2),
                Integer.valueOf(127), Integer.valueOf(128),
                Integer.valueOf(256));

        Supplier<IntStream> streamSupplier = () -> supplierIntStream.get()
                .filter(i -> ints.stream().anyMatch(s -> s == i))
                .filter(i -> i % 2 == 0);

        System.out.println("Sum of elements: "+streamSupplier.get().sum());

        System.out.println("Elements:");
        streamSupplier.get()
                .mapToObj(Integer::toString)
                .reduce((s1, s2) -> s1 + ", " + s2)
                .ifPresent(System.out::println);
    }
}
