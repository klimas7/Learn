package pl.klimas7.learn.thread.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class SimpleExecutor {
    public static void main(String[] args) {
        runnable();
        callable();
    }

    private static void callable() {
        Callable<Integer> call1 = () -> IntStream.range(0,10).sum();
        Callable<Integer> call2 = () -> IntStream.range(10,20).sum();
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            List<Future<Integer>> futures = executor.invokeAll(Arrays.asList(call1,call2));
            Integer sum = 0;
            for (Future<Integer> future : futures ) {
                sum += future.get();
            }
            System.out.println("SUM: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runnable() {
        Runnable hellos = () -> IntStream.range(0,1000).forEach(i -> System.out.println("Hello " + i + " " + Thread.currentThread().getName()));

        Runnable bays = () -> IntStream.range(0,1000).forEach(i -> System.out.println("Bay " + i + " " + Thread.currentThread().getName()));

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(bays);
    }
}
