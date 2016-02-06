package pl.klimas7.learn.flight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlightPrice
{
  private static Integer DEFAULT_CURRENCY_SCALE = Integer.valueOf(2);
  private static Integer RATIO_SCALE = Integer.valueOf(2);

  private BigDecimal basePrice = null;
  private List<BigDecimal> taxs = null;
  private Integer currencyScale = null;

  public FlightPrice()
  {
    this(0.F);
  }

  public FlightPrice(Float inBasePrice)
  {
    if (inBasePrice < 0.0F)
      throw new IllegalArgumentException("Base price is negative");

    setCurrencyScale(DEFAULT_CURRENCY_SCALE);
    basePrice = convertAndRoundFloatToBD(inBasePrice);
    taxs = new ArrayList<BigDecimal>();
  }

  public FlightPrice(Float inBasePrice, Float... taxss)
  {
    this(inBasePrice);
    for (Float tax : taxss)
    {
      if (tax < 0.0F)
        throw new IllegalArgumentException("Tax is negative");
      taxs.add(convertAndRoundFloatToBD(tax));
    }
  }

  public Integer getCurrencyScale()
  {
    return currencyScale;
  }

  public void setCurrencyScale(Integer currencyScale)
  {
    this.currencyScale = currencyScale;
  }

  public BigDecimal getBasePrice()
  {
    return basePrice;
  }

  public void setBasePrice(BigDecimal inBasePrice)
  {
    basePrice = inBasePrice;
    basePrice = setScaleForAmount(basePrice);
  }

  public List<BigDecimal> getTaxs()
  {
    return taxs;
  }

  public void setTaxs(List<BigDecimal> taxs)
  {
    this.taxs = taxs;
  }

  public BigDecimal getTotalPrice()
  {
    BigDecimal total = BigDecimal.ZERO;
    total = total.add(basePrice);
    for (BigDecimal tax : taxs)
      total = total.add(tax);

    total = setScaleForAmount(total);
    return total;
  }

  public void recalculateFlightPriceUsenigPriceLimit(Float priceLimit)
  {
    BigDecimal priceLimitBD = convertAndRoundFloatToBD(priceLimit);

    checkPriceLimit(priceLimitBD);
    
    BigDecimal ratioPrice = calculateRatio(priceLimitBD);
    recalculateBasePriceAndTax(ratioPrice);
    alignTotalPriceToLimit(priceLimitBD);
  }

  private BigDecimal convertAndRoundFloatToBD(Float number)
  {
    BigDecimal numberBD = new BigDecimal(number);
    return setScaleForAmount(numberBD);
  }

  private void checkPriceLimit(BigDecimal priceLimitBD)
  {
    if (priceLimitBD.compareTo(BigDecimal.ZERO) == -1)
      throw new IllegalArgumentException("Price limit is negative");
  }

  private BigDecimal calculateRatio(BigDecimal priceLimitBD)
  {
    Integer scale = RATIO_SCALE * currencyScale;
    if (scale == 0)
      scale = RATIO_SCALE;
    BigDecimal ratioPrice = new BigDecimal(0);
    ratioPrice = ratioPrice.add(priceLimitBD);
    ratioPrice = ratioPrice.divide(getTotalPrice(),scale,BigDecimal.ROUND_HALF_UP);
    return ratioPrice;
  }

  private void recalculateBasePriceAndTax(BigDecimal ratioPrice)
  {
    basePrice = basePrice.multiply(ratioPrice);
    basePrice = setScaleForAmount(basePrice);
    for (int i = 0; i < taxs.size(); i++)
    {
      BigDecimal tmp = taxs.get(i).multiply(ratioPrice);
      taxs.set(i,setScaleForAmount(tmp));
    }
  }

  private void alignTotalPriceToLimit(BigDecimal priceLimitBD)
  {
    BigDecimal lvDiff = getTotalPrice().subtract(priceLimitBD);
    if (lvDiff.compareTo(BigDecimal.ZERO) != 0)
    {
      for (int i = taxs.size() - 1; i >= 0; i--)
      {
        if (taxs.get(i).compareTo(BigDecimal.ZERO) != 0)
        {
          taxs.set(i,taxs.get(i).subtract(lvDiff));
          break;
        }
      }
    }
    
    lvDiff = getTotalPrice().subtract(priceLimitBD);
    if (lvDiff.compareTo(BigDecimal.ZERO) != 0)
    {
      basePrice = basePrice.subtract(lvDiff);
    }
  }

  private BigDecimal setScaleForAmount(BigDecimal amount)
  {
    return amount.setScale(currencyScale,BigDecimal.ROUND_HALF_UP);
  }
}
