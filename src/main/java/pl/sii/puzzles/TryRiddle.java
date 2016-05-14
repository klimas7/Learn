package pl.sii.puzzles;

public class TryRiddle {
    static class A {
        public static String test() {
            try {
                if (true) {
                    throw new RuntimeException("Runtime Exception");
                }
                return "A";
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return "B";
            } finally {
                return "C";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(A.test());
    }
}
