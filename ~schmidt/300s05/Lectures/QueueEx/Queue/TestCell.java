package Queue;
public class TestCell
{
  /** lengthOf calculates the number of cells in a linked list
    * @param l - the leading cell of the list
    * @return the length of the linked list  */
  public int lengthOf(Cell l)
  { int length = 0;
    if ( l == null )
       { length = 0; }
    else { length = 1 + lengthOf(l.getNext());}
    return length;
  }

/** append constructs a list that is its two arguments connected together.
  * @param l1 - the first list
  * @param l2 - the second list
  * @return the address of the concatenated list  */
public Cell append(Cell l1, Cell l2)
{ Cell answer;
  if ( l1 == null )
       { answer = l2; }
  else { Cell c = append(l1.getNext(), l2);
         answer = new Cell( l1.getVal(), c);
       }
  return answer;
}

}

