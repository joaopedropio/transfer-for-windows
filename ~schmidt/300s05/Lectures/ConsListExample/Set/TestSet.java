
package Set;
public class TestSet
{
  public static void main(String[] a)
  {
    Set x = new Set();
    x.add("fred");
    x.add("ethel");

    System.out.println(x.toString());

    if ( x.member("fred") )
         { System.out.println("fred is a member"); }

    Set y = new Set();
    y.add("lucy");
    y.add("ethel");

    x.unionWith(y);
    System.out.println(x.toString());

    x.intersectBy(y);
    System.out.println(x.toString());
  }
}
