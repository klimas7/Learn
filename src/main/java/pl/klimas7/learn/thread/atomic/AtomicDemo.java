package pl.klimas7.learn.thread.atomic;

import pl.klimas7.learn.thread.atomic.AtomicCounter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter atomicCounter = new AtomicCounter();
        Counter noAtomicCounter = new NoAtomicCounter();

        List<AtomicWorker> atomicThreads = init(atomicCounter);
        List<AtomicWorker> noAtomicThreads = init(noAtomicCounter);

        start(atomicThreads);
        start(noAtomicThreads);

        join(atomicThreads);
        join(noAtomicThreads);

        System.out.println("Atomic count: " + atomicCounter.getCount());
        System.out.println("No atomic count: " + noAtomicCounter.getCount());

    }

    private static List<AtomicWorker> init(Counter atomicCounter) {
        // create 1000 threads
        List<AtomicWorker> atomicThreads = new ArrayList<AtomicWorker>();
        for (int x = 0; x < 1000; x++) {
            atomicThreads.add(new AtomicWorker(atomicCounter));
        }
        return atomicThreads;
    }

    private static void start(List<AtomicWorker> atomicThreads) {
        // start all of the threads
        for (AtomicWorker mt : atomicThreads) {
            mt.start();
        }
    }

    private static void join(List<AtomicWorker> atomicThreads) throws InterruptedException {
        // wait for all the threads to finish
        Iterator<AtomicWorker> i2 = atomicThreads.iterator();
        while (i2.hasNext()) {
            AtomicWorker mt = (AtomicWorker) i2.next();
            mt.join();
        }
    }

}
