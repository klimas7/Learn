package pl.klimas7.learn.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class NoAtomicCounter implements Counter{
    private int counter = 0;

    @Override
    public void incrementCount() {
        counter++;
    }

    @Override
    public int getCount() {
        return counter;
    }
}
