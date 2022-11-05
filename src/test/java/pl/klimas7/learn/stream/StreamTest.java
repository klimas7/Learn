package pl.klimas7.learn.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class StreamTest {

    @Test
    public void sss() {
        List<Name> names = null;//List.of(new Name("x"), new Name("y"), new Name("z"));

//        List<String> xxx = names.stream().map(Name::getName).collect(Collectors.toList());
        //System.out.println(xxx);

        List<String> yyy = ofNullable(names)
                .map(Collection::stream)
                .map(s -> s.map(Name::getName))
                .map(s -> s.collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        System.out.println(yyy);
    }

    @Data
    @AllArgsConstructor
    static class Name {
        private String name;
    }
}
