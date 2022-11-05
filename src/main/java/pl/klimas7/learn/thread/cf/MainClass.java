package pl.klimas7.learn.thread.cf;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var cf = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName());
        cf = cf.thenApply(String::toUpperCase);
        System.out.println(cf.get());
    }
}
