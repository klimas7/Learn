package pl.sii.puzzles;

public class Argsss {

    public static void main(String[] args) {
        test(getSimpleObject());
    }

    private static SimpleObject getSimpleObject() {
        return null;
    }


    public static void test(SimpleObject... args) {
        if (args == null) {
            System.out.println("args null");
            return;
        }

        for (SimpleObject arg : args) {
            System.out.println(arg);
        }
    }
}
