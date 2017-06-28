
package Set;
import ConsList.*;

/** Set implements a set of objects, where no duplicate objects are kept.  */
public class Set
{
  private ConsList s;  // holds the objects belonging to the set

  /** Constructor Set builds a new, empty set */
  public Set()
  { s = new Nil(); }

  /** member checks if  ob  belongs to this set.
    * @param ob - the object searched for
    * @return true, if  ob  belongs to this set; return false otherwise */
  public boolean member(Object ob)
  { return  find(ob, s); }

  /** find attempts to locate Object  ob  in ConsList  elems
    *  by searching  elems  from front to rear.  */
  private boolean find(Object ob, ConsList elems)
  { boolean answer;
    if ( elems instanceof Nil )
         { answer = false; }  // nothing belongs to the empty set
    else { Object first = elems.head();
           if ( first == ob ) // is  ob  at the front of  elems ?
                { answer = true; }  // yes, so return true
           else { answer = find(ob, elems.tail()); }  // no, so look further 
         }
    return answer;
  }

  /** isEmpty checks if this set is empty
    * @return true, if this set is empty; false otherwise */
  public boolean isEmpty()
  { return ( s instanceof Nil ); }

  /** add inserts  ob  into this set (if it is not already present)
    * @param ob - the object inserted  */
  public void add(Object ob)
  { if ( ! this.member(ob) )
       { s = new Cons(ob, s); }
  }

  /** makeDuplicate ``clones'' a new Set object that is an exact copy
    * of this one.
    * @return the duplicate Set object  */
  public Set makeDuplicate()
  { Set answer = new Set();
    copyElements(s, answer); // copy the elements, s, in this set into answer
    return answer;
  }

  /** copyElements copies, one by one, the objects held in ConsList  elems
    *  into the Set,  a  */
  private void copyElements(ConsList elems, Set a)
  { if ( elems instanceof Nil )
         {} // finished
    else { a.add(elems.head());   // add front element of  elems  to  a
           copyElements(elems.tail(), a);  // process what's left in  elems
         }
  }

  /** unionWith copies all the elements in  other  into this set
    * @param other - the Set whose elements are unioned (copied) to this set */
  public void unionWith(Set other)
  { // let's copy the elements of this set into a duplicate copy of other:
    Set temp = other.makeDuplicate();
    copyElements(s, temp);
    // now,  the ConsList  inside  temp  holds exactly what we want,
    //  so use this Java trick to grab it:
    s = temp.s;
  }

  /** intersectBy updates this set so that it holds only the intersection
    *  of this set by the elements of  other
    * @param other - the set whose elements are intersecting this set */
  public void intersectBy(Set other)
  {  s = filter(s, other); }  // use  filterElements  to remove
         // those objects in ConsList  s  that are not members of  other

  /** filter _removes_ from ConsList elems those objects that are
    *  _not_ members of other.  The result is an intersection of the two. */
  private ConsList filter(ConsList elems, Set other)
  { ConsList answer;
    if ( elems instanceof Nil )
         { answer = elems; }   // finished
    else { if ( other.member(elems.head()) )  // front object of elems in other?
                // yes, so keep it in the  answer:
                { answer = new Cons(elems.head(), filter(elems.tail(),other)); }
           else // no, so forget about it and filter the rest of  elems:
                { answer = filter(elems.tail(),other); }
         }
    return answer;
  }

  /** toString amkes a string that lists the objects held in this set 
    * @return the string */
  public String toString()
  { return makeString(s); }

  /** makeString makes a string that lists the objects in ConsList elems */
  private String makeString(ConsList elems)
  { String answer;
    if ( elems instanceof Nil )
         { answer = ""; }
    else { answer = elems.head().toString() + " " + makeString(elems.tail()); }
    return answer;
  }
}

