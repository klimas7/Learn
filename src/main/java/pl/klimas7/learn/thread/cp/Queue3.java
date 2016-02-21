package pl.klimas7.learn.thread.cp;

public class Queue3 implements IQueue
{
  private Integer n;

  public Integer get()
  {
    System.out.println("Get: " + n);
    Thread.yield();
    return n;
  }

  public  void put(Integer n)
  {
    this.n = n;
    System.out.println("Put: " + n);
    Thread.yield();
  }
}
