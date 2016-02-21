package pl.klimas7.learn.thread.cp;

public class Producent implements Runnable
{
  private IQueue queue;

  public Producent(IQueue queue)
  {
    this.queue = queue;
    Thread prod = new Thread(this,"Producent");
    prod.setPriority(Thread.MIN_PRIORITY);
    prod.start();
  }

  public void run()
  {
    int i = 0;
    while (true)
    {
      queue.put(i++);
    }
  }
}
