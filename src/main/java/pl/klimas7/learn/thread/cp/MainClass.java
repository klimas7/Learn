package pl.klimas7.learn.thread.cp;

public class MainClass
{
  public static void main(String[] args)
  {
    IQueue q = new Queue();
    //IQueue q = new Queue2();
    //IQueue q = new Queue3();
    new Producent(q);
    new Konsument(q);
    
    System.out.println("sss");
  }

}
