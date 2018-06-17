package pl.sii.puzzles;

import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Hint!
 * space !
 * abcdefghijklmnopqrstuvwxyz
 */
public class SiiCompanyV2 {

    public static void main(String[] args) {
        System.out.println(getDescription());
    }

    public static String getDescription() {
        int y = 4036;
        String cipher = "0j1x2T3x4j5x6!7b8u9Hx0s1f2!3xd4f5Q6m7b8!9p0xU1!2s3l4xX5p0";

        String description = cipher.chars()
                .filter(c -> (Character.isLetter(c) || c == '!') && c != 'x')
                .map(c -> --c) //Hint! Caesar cipher
                .boxed().collect(charsToString());

        description = Pattern.compile("\\s").splitAsStream(description)
                .map(s -> move(s))
                .collect(Collectors.joining(" "));

        return description + " " + (y-- >> 1);
    }

    private static String move(String s) {
        return s.substring(s.length() / 2, s.length()) + s.substring(0, s.length() / 2);
    }

    public static Collector<Integer, ?, String> charsToString() {
        return Collector.of(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append,
                StringBuilder::toString);
    }
}
