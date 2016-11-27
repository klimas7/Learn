package pl.klimas7.learn.addtable;

/**
 * Simple comment
 */
public class AddTable
{
  public static int[] add(int[] tabA, int[] tabB)
  {
    int[] tabLittle = tabA.length <= tabB.length ? tabA : tabB;
    int[] tabBig = tabA.length <= tabB.length ? tabB : tabA;

    int overflow = 0;
    for (int ixLittle = tabLittle.length - 1, ixBig = tabBig.length - 1; ixBig >= 0; ixLittle--, ixBig--)
    {
      int tmp = (ixLittle >= 0 ? tabLittle[ixLittle] : 0) + tabBig[ixBig] + overflow;
      if (tmp >= 10)
      {
        overflow = 1;
        tmp = tmp - 10;
      }
      else
        overflow = 0;
        
      tabBig[ixBig] = tmp;
      if (overflow == 0 & ixLittle < 0)
        break;
    }

    if (overflow == 1)
    {
      int[] tabC = new int[tabBig.length + 1];
      tabC[0] = 1;
      for (int i = 0; i < tabBig.length; i++)
        tabC[i + 1] = tabBig[i];
      tabBig = tabC;
    }

    return tabBig;
  }
}
