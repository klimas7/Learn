package pl.klimas7.learn.thread.other;

public class Other {
    public static void main(String[] args) {
        System.out.println("MT Start");

        var thread = new Thread(() -> {
            System.out.println("TO start");
            for (int i = 0; i < 5; i++) {
                System.out.println("TO " + i);
            }
            System.out.println("TO stop");
        });

        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("MT " + i);
        }
        System.out.println("MT stop");
    }
}
