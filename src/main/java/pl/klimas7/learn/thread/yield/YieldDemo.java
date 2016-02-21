package pl.klimas7.learn.thread.yield;

public class YieldDemo implements Runnable
{

  Thread t;

  public YieldDemo(String str)
  {

    t = new Thread(this,str);
    // this will call run() function
    t.start();
  }

  public void run() {

     for (int i = 0; i < 5; i++) {
      ySleep();
        // yields control to another thread every 5 iterations
           if ((i % 5) == 0) {
              System.out.println(Thread.currentThread().getName() + " yielding control...");
              
              /* causes the currently executing thread object to temporarily 
              pause and allow other threads to execute */
              Thread.yield();
           }
     }

     System.out.println(Thread.currentThread().getName() + " has finished executing.");
  }

  private void ySleep()
  {
    try
    {
      Thread.sleep(100);
    }
    catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public static void main(String[] args)
  {
    new YieldDemo("Thread 1");
    new YieldDemo("Thread 2");
    new YieldDemo("Thread 3");
  }

}
