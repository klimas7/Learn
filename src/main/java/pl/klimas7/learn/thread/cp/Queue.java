package pl.klimas7.learn.thread.cp;

public class Queue implements IQueue {
    private Integer n;
    boolean isSetValue = false;

    public synchronized Integer get() {
        if (!isSetValue) {
            qWait();
        }
        System.out.println("Get: " + n);
        isSetValue = false;
        notify();
        return n;
    }

    private void qWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void put(Integer n) {
        if (isSetValue)
            qWait();

        this.n = n;
        isSetValue = true;
        System.out.println("Put: " + n);
        notify();
    }
}
