package pl.sii.puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SiiCache {
    private static Map<String, SiiValue> cache = new HashMap<>();

    public static void main(String[] args) {
        print(getFromCache("Sii", "Fun"));
    }

    private static SiiValue getFromCache(String key, String value) {
        return cache.putIfAbsent(key, new SiiValue(value));
    }

    public static void print(SiiValue... args) {
        if (args == null) {
            System.out.println("args null");
            return;
        }

        Arrays.stream(args).forEach(System.out::println);
    }

    private static class SiiValue {
        private final String value;

        private SiiValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value: " + value;
        }
    }
}
