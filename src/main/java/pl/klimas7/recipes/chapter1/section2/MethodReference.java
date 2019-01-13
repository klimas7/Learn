package pl.klimas7.recipes.chapter1.section2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(x -> System.out.println(x)); //Lambda expresion

        System.out.println("============================================");
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(System.out::println); //Method reference

        System.out.println("============================================");
        Consumer<Integer> printer = System.out::println; //Functional interface
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(printer);

        System.out.println("============================================");
        Stream.generate(Math::random)           //Static method
                .limit(10)
                .forEach(System.out::println);  //Method reference

        System.out.println("============================================");
        List<String> strings = Arrays.asList("this", "is", "list", "of", "strings");

        List<String> sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        sorted.forEach(System.out::println);

        sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        sorted.forEach(System.out::println);

        sorted = strings.stream().sorted().collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println("============================================");
        Stream.of("this", "is", "list", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);
    }
}
