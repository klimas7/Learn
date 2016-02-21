package pl.klimas7.learn.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void incrementCount() {
        counter.incrementAndGet();
    }

    @Override
    public int getCount() {
        return counter.get();
    }
}
