
package ConsList;
/** ListOps  define some standard operations for processing ConsLists */
public class ListOps
{ 
  /** lengthOf calculates the number of cells in a list
    * @param l - the list
    * @return the length of the list  */
  public int lengthOf(ConsList l)
  { int length = 0;
    if ( l instanceof Nil )
         { length = 0; }
    else // l instanceof Cons  must be true:
         { length = 1 + lengthOf(l.tail()); }
    return length;
  }

  /** toString constructs a string that holds all the values in a list
    * @param l - the list
    * @return a single string holding all the values.  */
  public String toString(ConsList l)
  { String answer;
    if ( l instanceof Nil )
         { answer = ""; }
    else { answer = l.head().toString() + " " + toString(l.tail()); }
    return answer;
  }

  /** append  constructs a new list that has the same contents as list1
    *  followed by list2
    * @param list1 - the first list
    * @param list2 - the second list
    * @return a list holding the contents of list1 followed by list2 */
  public ConsList append(ConsList list1, ConsList list2)
  { ConsList answer;
    if ( list1 instanceof Nil )
         { answer = list2; }
    else { answer = new Cons(list1.head(),
                           append(list1.tail(), list2));
       }
    return answer;
  }

  /** reverse  constructs a new list that looks just like  l  but its
    *  contents are listed in reverse order. 
    * @param l - the original list
    * @return a new list whose contents are  l's but in reverse order. */
  public ConsList reverse(ConsList l)
  { ConsList answer;
    if ( l instanceof Nil )
         { answer = l; }
    else { answer = append(reverse(l.tail()),
                        new Cons(l.head(), new Nil()));
         }
    return answer;
  } 

}

