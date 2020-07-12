package pl.klimas7.learn.java8;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

class PredicatesTest {

    @org.junit.jupiter.api.Test
    void filter() {
        Predicates predicates = new Predicates();
        List<String> filter = predicates.filter();

        Assertions.assertEquals(Arrays.asList("AAB", "AAC"), filter);
    }
}