package pl.klimas7.learn.thread.cp;

import pl.klimas7.learn.thread.cp.IQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue2 implements IQueue {
    private Lock lock = null;
    private Condition conditionGet = null;
    private Condition conditionPut = null;
    private Integer n;
    boolean isSetValue = false;

    public Queue2() {
        lock = new ReentrantLock();
        conditionGet = lock.newCondition();
        conditionPut = lock.newCondition();
        isSetValue = false;
    }

    @SuppressWarnings("finally")
    public Integer get() {
        lock.lock();

        try {
            if (!isSetValue)
                conditionPut.await();

            System.out.println("Get: " + n);
            isSetValue = false;
            conditionGet.signal();
        } finally {
            lock.unlock();
            return n;
        }

    }

    public void put(Integer n) {
        lock.lock();

        try {
            if (isSetValue)
                try {
                    conditionGet.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            this.n = n;
            System.out.println("Put: " + n);
            isSetValue = true;
            conditionPut.signal();
        } finally {
            lock.unlock();
        }
    }

}
