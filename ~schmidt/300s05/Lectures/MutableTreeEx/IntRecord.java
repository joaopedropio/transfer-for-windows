
import MutableOrderedTree.*;

public class IntRecord implements Record
{
  private IntKey key;
 
  public IntRecord(int j)
  { key = new IntKey(j); }

  public Key getKey()
  { return key; }

  public String toString()
  { return  "Record " + key.toString(); }
}
