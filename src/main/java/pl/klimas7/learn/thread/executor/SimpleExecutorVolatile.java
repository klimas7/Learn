package pl.klimas7.learn.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SimpleExecutorVolatile {
    private static volatile boolean done = false;

    public static void main(String[] args) {
        runnable();
    }


    private static void runnable() {

        Runnable hellos = () -> {
            IntStream.range(0,1000).forEach(i -> System.out.println("Hello " + i));
            done = true;
        };

        Runnable bays = () -> {
            int i = 1;
            while (!done) {
                i++;
            }
            System.out.println("Bay " + i);
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(bays);
    }
}
