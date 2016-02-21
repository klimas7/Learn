package pl.klimas7.learn.thread;

/**
 * @author bklimas
 *
 */
public class MainClass
{
  public static void main(String[] args)
  {
    System.out.println("Witam");
    
    watekDane();
    seperatorPrzypadkow();
    grupyWatkow();
    seperatorPrzypadkow();
    
    Thread1 t1 = new Thread1("T1");
    t1.start();
    System.out.println("T1 Status: " + t1.getState());
    t1.interrupt();
    System.out.println("T1 Status: " + t1.getState());
  }
  
  


  private static void seperatorPrzypadkow()
  {
    System.out.println("======================================");
  }

  private static void watekDane()
  {
    long id = Thread.currentThread().getId();
    String name = Thread.currentThread().getName();
    System.out.println(id + " "+name + " "+ Thread.currentThread().getState());
    System.out.println(Thread.currentThread().getPriority());
  }
  
  
  
  public static void grupyWatkow()
  {
    ThreadGroup tg = new ThreadGroup ("subgroup 1");
    Thread t1 = new Thread (tg, "thread 1");
    Thread t2 = new Thread (tg, "thread 2");
    Thread t3 = new Thread (tg, "thread 3");
    tg = new ThreadGroup ("subgroup 2");
    Thread t4 = new Thread (tg, "my thread");
    tg = Thread.currentThread ().getThreadGroup ();
    int agc = tg.activeGroupCount ();
    System.out.println ("Active thread groups in " + tg.getName () +
                        " thread group: " + agc);
    tg.list();
  }
}
