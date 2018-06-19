package pl.sii.puzzles;

import java.util.Optional;

interface A {
    default void a() {
        System.out.println("A");
    }
}

interface B {
    default void b() {
        System.out.println("B");
    }
}

public class SiiInterface {
    public static void main(String[] args) {
        class AB implements A, B {
        }
        test(new AB());
    }

    private static void test(Object ab) {
        Optional.of((B & A) ab)
                .ifPresent(x -> {
                    x.a();
                    x.b();
                });
    }
}
