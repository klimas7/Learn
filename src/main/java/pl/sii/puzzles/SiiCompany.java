package pl.sii.puzzles;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SiiCompany {
    public String getDescription() {
        int y = 0xFC4;
        String cipher = "0j1x2T3x4j5x6!7b8u9Hx0s1f2!3xd4f5Q6m7b8!9p0xU1!2s3l4xX5p0";
        String description = cipher.chars().filter(c -> (Character.isAlphabetic(c) || c == 0x21) && c != 120)
                .map(c -> --c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        description = Pattern.compile("\\s").splitAsStream(description)
                .map(s -> s.substring(s.length() / 2, s.length()) + s.substring(0, s.length() / 2))
                .collect(Collectors.joining(" "));

        return description + " " + Integer.toString(y-- >> 1);
    }
}
