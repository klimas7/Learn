package pl.klimas7.learn.addtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class AddTableTest
{
  /*
   *   1234
   * + 1234
   * = 2468 
   */
  @Test
  public void addTestA()
  {

    int[] tabA = new int[]{1, 2, 3, 4};
    int[] tabB = new int[]{1, 2, 3, 4};

    int[] tabC = new int[]{2, 4, 6, 8};
    throw new SkipException("ddd");
    //assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *   1234
   * + 1238
   * = 2472  
   */
  @Test
  public void addTestB()
  {
    int[] tabA = new int[]{1, 2, 3, 4};
    int[] tabB = new int[]{1, 2, 3, 8};

    int[] tabC = new int[]{2, 4, 7, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  
  /*
   *     4234
   *  +  9238
   *  = 13472
   */
  @Test
  public void addTestC()
  {
    int[] tabA = new int[]{4, 2, 3, 4};
    int[] tabB = new int[]{9, 2, 3, 8};

    int[] tabC = new int[]{1, 3, 4, 7, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *    1234
   *  +   38
   *  = 1272  
   */ 
  @Test
  public void addTestD()
  {
    int[] tabA = new int[]{1, 2, 3, 4};
    int[] tabB = new int[]{3, 8};

    int[] tabC = new int[]{1, 2, 7, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /* 
   *    1234
   *  +
   *  = 1234  
   */
  @Test
  public void addTestE()
  {
    int[] tabA = new int[]{1, 2, 3, 4};
    int[] tabB = new int[]{};

    int[] tabC = new int[]{1, 2, 3, 4};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *    
   *  + 1234
   *  = 1234  
   */
  @Test
  public void addTestF()
  {
    int[] tabA = new int[]{};
    int[] tabB = new int[]{1, 2, 3, 4};

    int[] tabC = new int[]{1, 2, 3, 4};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *   1234
   * +   88
   * = 1322  
   */
  @Test
  public void addTestG()
  {
    int[] tabA = new int[]{1, 2, 3, 4};
    int[] tabB = new int[]{8, 8};

    int[] tabC = new int[]{1, 3, 2, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *   1934
   * +   88
   * = 2022  
   */
  @Test
  public void addTestH()
  {
    int[] tabA = new int[]{1, 9, 3, 4};
    int[] tabB = new int[]{8, 8};

    int[] tabC = new int[]{2, 0, 2, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  /*
   *    9934
   * +    88
   * = 10022  
   */
  @Test
  public void addTestI()
  {
    int[] tabA = new int[]{9, 9, 3, 4};
    int[] tabB = new int[]{8, 8};

    int[] tabC = new int[]{1, 0, 0, 2, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  
  /*
   *   10009934
   * +       88
   * = 10010022
   */
  @Test
  public void addTestJ()
  {
    int[] tabA = new int[]{1, 0, 0, 0, 9, 9, 3, 4};
    int[] tabB = new int[]{8, 8};

    int[] tabC = new int[]{1, 0, 0, 1, 0, 0, 2, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  
  /*
   *   00009934
   * +       88
   * = 00010022
   */
  @Test
  public void addTestK()
  {
    int[] tabA = new int[]{0, 0, 0, 0, 9, 9, 3, 4};
    int[] tabB = new int[]{8, 8};

    int[] tabC = new int[]{0, 0, 0, 1, 0, 0, 2, 2};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  
  /*
   *   00001234
   * +       00
   * = 00001234
   */
  @Test
  public void addTestL()
  {
    int[] tabA = new int[]{0, 0, 0, 0, 1, 2, 3, 4};
    int[] tabB = new int[]{0, 0};

    int[] tabC = new int[]{0, 0, 0, 0, 1, 2, 3, 4};

    assertTrue(Arrays.equals(tabC,AddTable.add(tabA,tabB)));
  }
  
  @Test
  public void constructorTest()
  {
    AddTable addTable = new AddTable();
    assertNotNull(addTable);
  }
}
