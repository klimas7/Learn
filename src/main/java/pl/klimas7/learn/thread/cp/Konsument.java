package pl.klimas7.learn.thread.cp;

public class Konsument implements Runnable
{
  private IQueue queue;

  public Konsument(IQueue queue)
  {
    this.queue = queue;
    Thread kons = new Thread(this,"Konsument");
    kons.setPriority(Thread.MAX_PRIORITY);
    kons.start();
  }

  public void run()
  {
    while (true)
    {
      queue.get();
    }
  }
}