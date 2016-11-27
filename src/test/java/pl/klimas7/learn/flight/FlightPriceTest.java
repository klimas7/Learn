package pl.klimas7.learn.flight;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlightPriceTest
{
  private static Integer DEFAULT_CURRENCY_SCALE = Integer.valueOf(2);

  private static BigDecimal convertAndRoundFloatToBD(Float number)
  {
    return convertAndRoundFloatToBD(number,DEFAULT_CURRENCY_SCALE);
  }

  private static BigDecimal convertAndRoundFloatToBD(Float number, Integer scale)
  {
    BigDecimal numberBD = new BigDecimal(number);
    return numberBD.setScale(scale,BigDecimal.ROUND_HALF_UP);
  }

  @Test
  public void testFlightPrice()
  {
    FlightPrice test1 = new FlightPrice();
    assertEquals(true,test1.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);
    assertEquals(true,test1.getBasePrice().compareTo(BigDecimal.ZERO) == 0);
    assertEquals(true,test1.getTaxs().size() == 0);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFlightPriceThrow()
  {
    FlightPrice test3 = new FlightPrice(-1.0F);
    test3.getBasePrice();
    //...
  }

  @Test
  public void testFlightPrice2()
  {
    FlightPrice test1 = new FlightPrice(0.0F);
    assertEquals(true,test1.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);
    assertEquals(true,test1.getBasePrice().compareTo(BigDecimal.ZERO) == 0);
    assertEquals(true,test1.getTaxs().size() == 0);

    FlightPrice test2 = new FlightPrice(1.0F);
    assertEquals(false,test2.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);
    assertEquals(true,test2.getTotalPrice().compareTo(BigDecimal.ONE) == 0);
    assertEquals(true,test2.getBasePrice().compareTo(BigDecimal.ONE) == 0);
    assertEquals(true,test2.getTaxs().size() == 0);

    FlightPrice test3 = new FlightPrice(1.55F);
    BigDecimal testBD = convertAndRoundFloatToBD(1.55F);
    assertEquals(true,test3.getTotalPrice().compareTo(testBD) == 0);

    FlightPrice test4 = new FlightPrice(1.336F);
    testBD = convertAndRoundFloatToBD(1.34F);
    assertEquals(true,test4.getTotalPrice().compareTo(testBD) == 0);

  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testFlightPrice3Throws()
  {
    FlightPrice test1 = new FlightPrice(1.0F,-1.0F);
    assertEquals(true,test1.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);
  }

  @Test
  public void testFlightPrice3()
  {
    FlightPrice test1 = new FlightPrice(0.0F,0.0F);
    assertEquals(true,test1.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);

    FlightPrice test2 = new FlightPrice(0.0F,0.0F,0.0F);
    assertEquals(true,test2.getTotalPrice().compareTo(BigDecimal.ZERO) == 0);

    FlightPrice test3 = new FlightPrice(5.0F,2.5F,2.5F);
    assertEquals(true,test3.getTotalPrice().compareTo(BigDecimal.TEN) == 0);

    FlightPrice test4 = new FlightPrice(5.005F,2.5F,2.493F);
    assertEquals(true,test4.getTotalPrice().compareTo(BigDecimal.TEN) == 0);
  }

  @Test
  public void testGetTaxs()
  {
    FlightPrice test1 = new FlightPrice(0.0F,0.0F);
    assertEquals(true,test1.getTaxs().size() == 1);

    FlightPrice test2 = new FlightPrice(0.0F,0.0F,0.0F);
    assertEquals(true,test2.getTaxs().size() == 2);
    assertEquals(true,test2.getTaxs().get(1).compareTo(BigDecimal.ZERO) == 0);

    FlightPrice test3 = new FlightPrice(0.0F,0.0F,10.001F);
    assertEquals(true,test3.getTaxs().size() == 2);
    assertEquals(true,test3.getTaxs().get(1).compareTo(BigDecimal.TEN) == 0);
    assertEquals(true,test3.getTotalPrice().compareTo(BigDecimal.TEN) == 0);
  }

  @Test
  public void testSetTaxs()
  {
    FlightPrice test1 = new FlightPrice(0.0F,0.0F);
    assertEquals(true,test1.getTaxs().size() == 1);

    List<BigDecimal> taxs = new ArrayList<BigDecimal>(2);
    taxs.add(BigDecimal.ONE);
    taxs.add(BigDecimal.ONE);
    test1.setTaxs(taxs);

    assertEquals(true,test1.getTaxs().size() == 2);
    assertEquals(true,test1.getTaxs().get(1).compareTo(BigDecimal.ONE) == 0);

  }

  @Test
  public void testBasePrice()
  {
    FlightPrice testFlightPrice = new FlightPrice();
    assertEquals(true,testFlightPrice.getBasePrice().compareTo(BigDecimal.ZERO) == 0);

    testFlightPrice.setBasePrice(new BigDecimal(1.0));
    assertEquals(true,testFlightPrice.getBasePrice().compareTo(BigDecimal.ONE) == 0);

    testFlightPrice.setBasePrice(new BigDecimal(10.0));
    assertEquals(true,testFlightPrice.getBasePrice().compareTo(BigDecimal.TEN) == 0);

    testFlightPrice.setBasePrice(new BigDecimal(1.553));
    BigDecimal testBD = new BigDecimal(1.553);
    assertEquals(false,testFlightPrice.getBasePrice().compareTo(testBD) == 0);

    testBD = testBD.setScale(2,BigDecimal.ROUND_HALF_UP);
    assertEquals(true,testFlightPrice.getBasePrice().compareTo(testBD) == 0);

    testFlightPrice.setBasePrice(new BigDecimal(1.555));
    testBD = new BigDecimal(1.555);
    assertEquals(false,testFlightPrice.getBasePrice().compareTo(testBD) == 0);

    testBD = testBD.setScale(2,BigDecimal.ROUND_HALF_UP);
    assertEquals(true,testFlightPrice.getBasePrice().compareTo(testBD) == 0);
  }
  @Test
  public void getCurrencyScale()
  {
    FlightPrice test = new FlightPrice();
    assertEquals(Integer.valueOf(2),test.getCurrencyScale());

    test.setCurrencyScale(Integer.valueOf(3));
    assertEquals(Integer.valueOf(3),test.getCurrencyScale());

  }
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRecalculateFlightPriceUsenigPriceLimitThrow()
  {
    FlightPrice test = new FlightPrice(10.0F,5.0F,5.0F);
    test.recalculateFlightPriceUsenigPriceLimit(-5.0F);
  }

  /**
  Base = 10
  Tax = 5
  Tax = 5
  
  total price limit = 21
  
  Result:
  
  Base = 10.5
  Tax - 5.25
  Tax - 5.25
   */

  @Test
  public void testPriceLimitGreatWithTotalPrice()
  {
    FlightPrice test = new FlightPrice(10.0F,5.0F,5.0F);
    test.recalculateFlightPriceUsenigPriceLimit(21.0F);

    BigDecimal _21 = convertAndRoundFloatToBD(21.F);
    assertEquals(true,test.getTotalPrice().compareTo(_21) == 0);

    BigDecimal _10_5 = convertAndRoundFloatToBD(10.5F);
    assertEquals(true,test.getBasePrice().compareTo(_10_5) == 0);

    BigDecimal _5_25 = convertAndRoundFloatToBD(5.25F);
    assertEquals(true,test.getTaxs().get(0).compareTo(_5_25) == 0);
    assertEquals(true,test.getTaxs().get(1).compareTo(_5_25) == 0);
  }

  /**
  Base = 7
  Tax = 3
  Tax = 3
  Tax = 0
  
  total price limit = 17
  
  Result:
  
  Base = 9.15
  Tax - 3.92
  Tax - 3.93
  Tax - 0.00
  
   */

  @Test
  public void testPriceLimitGreatWithTotalPrice2()
  {
    FlightPrice test = new FlightPrice(7.0F,3.0F,3.0F,0.0F);
    test.recalculateFlightPriceUsenigPriceLimit(17.0F);

    BigDecimal _17 = convertAndRoundFloatToBD(17.F);
    assertEquals(true,test.getTotalPrice().compareTo(_17) == 0);

    BigDecimal _9_15 = convertAndRoundFloatToBD(9.15F);
    assertEquals(true,test.getBasePrice().compareTo(_9_15) == 0);

    BigDecimal _3_92 = convertAndRoundFloatToBD(3.92F);
    BigDecimal _3_93 = convertAndRoundFloatToBD(3.93F);
    assertEquals(true,test.getTaxs().get(0).compareTo(_3_92) == 0);
    assertEquals(true,test.getTaxs().get(1).compareTo(_3_93) == 0);
    assertEquals(true,test.getTaxs().get(2).compareTo(BigDecimal.ZERO) == 0);
  }

  /**
  Base = 10
  Tax = 5
  Tax = 5
  
  total price limit = 10
  
  Result:
  
  Base = 5
  Tax - 2.5
  Tax - 2.5
   */
  @Test
  public void testPriceLimitExampleOne()
  {
    FlightPrice test = new FlightPrice(10.0F,5.0F,5.0F);
    test.recalculateFlightPriceUsenigPriceLimit(10.0F);

    assertEquals(true,test.getTotalPrice().compareTo(BigDecimal.TEN) == 0);

    BigDecimal _5 = convertAndRoundFloatToBD(5.F);
    assertEquals(true,test.getBasePrice().compareTo(_5) == 0);

    BigDecimal _2_5 = convertAndRoundFloatToBD(2.5F);
    for (BigDecimal tax : test.getTaxs())
      assertEquals(true,tax.compareTo(_2_5) == 0);
  }
  /**
  Base = 9
  Tax = 1
  Tax = 1
  Tax = 1
  
  total price limit = 6
  
  Base = 4.5
  Tax = 0.5
  Tax = 0.5
  Tax = 0.5
   */
  @Test
  public void testPriceLimitExampleTwo()
  {
    FlightPrice test = new FlightPrice(9.0F,1.0F,1.0F,1.0F);
    test.recalculateFlightPriceUsenigPriceLimit(6.0F);

    BigDecimal _6 = convertAndRoundFloatToBD(6.F);
    assertEquals(true,test.getTotalPrice().compareTo(_6) == 0);

    BigDecimal _4_5 = convertAndRoundFloatToBD(4.5F);
    assertEquals(true,test.getBasePrice().compareTo(_4_5) == 0);

    BigDecimal _0_5 = convertAndRoundFloatToBD(0.5F);
    for (BigDecimal tax : test.getTaxs())
      assertEquals(true,tax.compareTo(_0_5) == 0);
  }

  /**
   Example 3:
  
   Base = 7
   Tax = 3
   Tax = 3
   
   total price limit = 7
  
   Base = 3.77
   Tax = 1.62
   Tax = 1.61
   */
  @Test
  public void testPriceLimitExampleThree()
  {
    FlightPrice test = new FlightPrice(7.0F,3.0F,3.0F);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    BigDecimal _3_77 = convertAndRoundFloatToBD(3.77F);
    assertEquals(true,test.getBasePrice().compareTo(_3_77) == 0);

    BigDecimal _1_62 = convertAndRoundFloatToBD(1.62F);
    assertEquals(true,test.getTaxs().get(0).compareTo(_1_62) == 0);

    BigDecimal _1_61 = convertAndRoundFloatToBD(1.61F);
    assertEquals(true,test.getTaxs().get(1).compareTo(_1_61) == 0);
  }

  /**
   Base = 9
   
   total price limit = 7
  
   Base = 7
   */
  @Test
  public void testPriceLimitExampleFour()
  {
    FlightPrice test = new FlightPrice(9.0F);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    assertEquals(true,test.getBasePrice().compareTo(_7) == 0);

    assertEquals(true,test.getTaxs().size() == 0);
  }

  /**
  Example 4:
  
  Base = 7
  Tax = 3
  Tax = 3
  
  total price limit = 7
  currency scale = 3 
   
  Base = 3.769
  Tax = 1.615
  Tax = 1.616
  */
  @Test
  public void testPriceLimitExampleTunisia()
  {
    Integer currencyScale = Integer.valueOf(3);

    FlightPrice test = new FlightPrice(7.0F,3.0F,3.0F);
    test.setCurrencyScale(currencyScale);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    BigDecimal _3_769 = convertAndRoundFloatToBD(3.769F,currencyScale);
    assertEquals(true,test.getBasePrice().compareTo(_3_769) == 0);

    BigDecimal _1_615 = convertAndRoundFloatToBD(1.615F,currencyScale);
    assertEquals(true,test.getTaxs().get(0).compareTo(_1_615) == 0);

    BigDecimal _1_616 = convertAndRoundFloatToBD(1.616F,currencyScale);
    assertEquals(true,test.getTaxs().get(1).compareTo(_1_616) == 0);
  }

  /**
  Example 5:
  
  Base = 7
  Tax = 3
  Tax = 3
  
  total price limit = 7
  currency scale = 0 
   
  Base = 4
  Tax = 2
  Tax = 1
  */
  @Test
  public void testPriceLimitExampleBelarus()
  {
    Integer currencyScale = Integer.valueOf(0);

    FlightPrice test = new FlightPrice(7.0F,3.0F,3.0F);
    test.setCurrencyScale(currencyScale);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    BigDecimal _4 = convertAndRoundFloatToBD(4.F,currencyScale);
    assertEquals(true,test.getBasePrice().compareTo(_4) == 0);

    BigDecimal _2 = convertAndRoundFloatToBD(2.F,currencyScale);
    assertEquals(true,test.getTaxs().get(0).compareTo(_2) == 0);

    BigDecimal _1 = convertAndRoundFloatToBD(1.F,currencyScale);
    assertEquals(true,test.getTaxs().get(1).compareTo(_1) == 0);
  }

  /**
  Example 6:
  
  Base = 7
  Tax = 3
  Tax = 3
  Tax = 0
  
  total price limit = 7
  currency scale = 3 
   
  Base = 3.769
  Tax = 1.615
  Tax = 1.616
  Tax = 0.000
  */
  @Test
  public void testPriceLimitExampleTunisiaLastTaxZero()
  {
    Integer currencyScale = Integer.valueOf(3);

    FlightPrice test = new FlightPrice(7.0F,3.0F,3.0F,0.0F);
    test.setCurrencyScale(currencyScale);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    BigDecimal _3_769 = convertAndRoundFloatToBD(3.769F,currencyScale);
    assertEquals(true,test.getBasePrice().compareTo(_3_769) == 0);

    BigDecimal _1_615 = convertAndRoundFloatToBD(1.615F,currencyScale);
    assertEquals(true,test.getTaxs().get(0).compareTo(_1_615) == 0);

    BigDecimal _1_616 = convertAndRoundFloatToBD(1.616F,currencyScale);
    assertEquals(true,test.getTaxs().get(1).compareTo(_1_616) == 0);

    BigDecimal _0 = convertAndRoundFloatToBD(0.F,currencyScale);
    assertEquals(true,test.getTaxs().get(2).compareTo(_0) == 0);
  }

  /**
  Example 6:
  
  Base = 7
  Tax = 6
  Tax = 0
  Tax = 0
  
  total price limit = 7
  currency scale = 3 
   
  Base = 3.769
  Tax = 3.231
  Tax = 0.000
  Tax = 0.000
  */
  @Test
  public void testPriceLimitExampleTunisiaFirstTaxNotZero()
  {
    Integer currencyScale = Integer.valueOf(3);

    FlightPrice test = new FlightPrice(7.0F,6.0F,0.0F,0.0F);
    test.setCurrencyScale(currencyScale);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);

    BigDecimal _3_769 = convertAndRoundFloatToBD(3.769F,currencyScale);
    assertEquals(true,test.getBasePrice().compareTo(_3_769) == 0);

    BigDecimal _3_231 = convertAndRoundFloatToBD(3.231F,currencyScale);
    assertEquals(true,test.getTaxs().get(0).compareTo(_3_231) == 0);

    BigDecimal _0 = convertAndRoundFloatToBD(0.F,currencyScale);
    assertEquals(true,test.getTaxs().get(1).compareTo(_0) == 0);
    assertEquals(true,test.getTaxs().get(2).compareTo(_0) == 0);
  }

  /**
  Example 7:
  
  Base = 9999
  Tax = 0
  Tax = 0
  Tax = 0
  
  total price limit = 7
  currency scale = 3 
   
  Base = 7.000
  Tax = 0.000
  Tax = 0.000
  Tax = 0.000
  */
  @Test
  public void testPriceLimitExampleTunisiaAllTaxZero()
  {
    Integer currencyScale = Integer.valueOf(3);

    FlightPrice test = new FlightPrice(9999.0F,0.0F,0.0F,0.0F);
    test.setCurrencyScale(currencyScale);
    test.recalculateFlightPriceUsenigPriceLimit(7.0F);

    BigDecimal _7 = convertAndRoundFloatToBD(7.F);
    assertEquals(true,test.getTotalPrice().compareTo(_7) == 0);
    assertEquals(true,test.getBasePrice().compareTo(_7) == 0);

    BigDecimal _0 = convertAndRoundFloatToBD(0.F,currencyScale);
    assertEquals(true,test.getTaxs().get(0).compareTo(_0) == 0);
    assertEquals(true,test.getTaxs().get(1).compareTo(_0) == 0);
    assertEquals(true,test.getTaxs().get(2).compareTo(_0) == 0);
  }
}
