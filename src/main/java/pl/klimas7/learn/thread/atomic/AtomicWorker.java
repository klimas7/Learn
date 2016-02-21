package pl.klimas7.learn.thread.atomic;

public class AtomicWorker extends Thread
{
  private Counter counter;

  public AtomicWorker(Counter counter)
  {
    this.counter = counter;
  }

  public void run()
  {
    int i = 0;
    while (i < 100000)
    {
      counter.incrementCount();
      i++;
    }
  }
}
