package pl.klimas7.learn.algorithm.heightTree;

/**
 * @author bklimas
 *
 */
public class MapTest
{
  private String p1 = null;
  private String p2 = null;
  private String p3 = null;
  
  public MapTest(String p1, String p2, String p3)
  {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
    result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
    //result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
    return result;
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MapTest other = (MapTest)obj;
    if (p1 == null)
    {
      if (other.p1 != null)
        return false;
    }
    else if (!p1.equals(other.p1))
      return false;
    if (p2 == null)
    {
      if (other.p2 != null)
        return false;
    }
    else if (!p2.equals(other.p2))
      return false;
/*    if (p3 == null)
    {
      if (other.p3 != null)
        return false;
    }
    else if (!p3.equals(other.p3))
      return false;*/
    return true;
  }
  
  
}
