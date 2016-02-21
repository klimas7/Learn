package pl.klimas7.learn.thread;

public class Thread1 extends Thread
{
  public Thread1(String name)
  {
    super(name);
  }
  
  @Override
  public void run()
  {
    System.out.println("Run: " +getName());
  }
}
