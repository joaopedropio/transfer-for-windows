
import MutableOrderedTree.*;

public class IntKey implements Key
{
  private int i;
 
  public IntKey(int j)
  { i = j; }

  public boolean equals(Key other)
  { return ( i == ((IntKey)other).getVal() ); }

  public boolean lessthan(Key other)
    { return ( i < ((IntKey)other).getVal() ); }

  public int getVal()
  { return i; }

  public String toString()
  { return "" + i; }
}
