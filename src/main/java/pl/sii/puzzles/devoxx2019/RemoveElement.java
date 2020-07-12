package pl.sii.puzzles.devoxx2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        list.stream().forEach(x -> {
            if (x.equals("C")) {
                list.remove(x);
            }
        });

        list.forEach(System.out::print);
    }
}
