package pl.klimas7.learn.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Predicates {

    public List<String> filter() {

        Predicate<String> stringFilter =
                ((Predicate<String>) s -> s.endsWith("B"))
                        .or(s -> s.endsWith("C"))
                        .and(s -> s.startsWith("A"));

        return Stream.of("AAA", "AAB", "AAC", "BBB")
                .filter(stringFilter)
                .collect(Collectors.toList());
    }
}
