package pl.sii.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SiiList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //list = list.subList(0,2);
        Stream<String> stream = list.stream();
        list.add("D");
        stream.forEach(System.out::println);
    }
}
