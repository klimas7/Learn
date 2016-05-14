package pl.sii.puzzles;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagicRiddle {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            int magic = i;
            System.out.println("Magic = " + i);
            int intResult =
                    Stream.iterate(new int[]{1, 1}, x -> new int[]{x[1], x[0] + x[1]})
                            .map(f -> f[0])
                            .limit(++magic) //.forEach(System.out::println);
                            .collect(Collectors.toList())
                            .get(--magic);

            System.out.println(magic + " " + intResult + " -> " + (magic == intResult));
            System.out.println("====");
        }
    }
}
/*
1,1  -> 1, 2
1,2  -> 2, 3
2,3  -> 3, 5
3,5  -> 5, 8
5,8  -> 8, 13
8,13 -> 13, 21
13,21 -> 21,34
*/