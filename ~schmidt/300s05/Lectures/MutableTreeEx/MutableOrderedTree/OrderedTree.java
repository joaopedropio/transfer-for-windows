
package MutableOrderedTree;

import MutableTree.*;
/** OrderedTree models a single, mutable, ordered tree that holds
     Records in its nodes.  Records can be inserted, found, and deleted. */
public class OrderedTree
{ private MutableTree otree;  // the ordered tree

  /** OrderedTree constructs the initially empty ordered tree */
  public OrderedTree()
  { otree = new Leaf(null); }


  /** makeNewNode is a helper method that builds a Node that holds 
    *  a  value  and links to  parent */
  private Node makeNewNode(Node parent, Object value)
  { Leaf empty1 = new Leaf(null);
    Leaf empty2 = new Leaf(null);
    Node new_node = new Node(parent, value, empty1, empty2);
    empty1.setParent(new_node);   // connect leaves to parent node
    empty2.setParent(new_node);
    return new_node;
  }

  /** insert inserts a Record into the ordered tree
    * @param r - the record to be inserted */
  public void insert(Record r)
  { otree = insertRecord(r, otree); 
    otree.setParent(null);   // the root node has no parent
  }

  /** insertRecord inserts Record  r  in its proper position in ordered tree  t
    * @return  the address of the altered tree  */
  private MutableTree insertRecord(Record r, MutableTree t)
  { MutableTree answer;
    if ( t instanceof Leaf )
         { answer = makeNewNode(null, r); }
    else // t is a Node:
         { Record t_value = (Record)(t.value());
           Key t_values_key = t_value.getKey();
           if ( r.getKey().lessthan(t_values_key) )
                { MutableTree new_left = insertRecord(r, t.left());  
                  t.setLeft(new_left);
                  new_left.setParent((Node)t);
                }
           else // insert into t's right subtree:
                { MutableTree new_right = insertRecord(r, t.right());  
                  t.setRight(new_right);
                  new_right.setParent((Node)t);
                }
           answer = t;
         }
    return answer;
  }


  /** find locates the record, if any, in the ordered tree whose key is  k.
    * @param k - the key used for the search
    * @return the address of the record whose key is equal to  k.
    *  If no record has Key k, then return  null.  */
  public Record find(Key k)
  { Record answer;
    MutableTree result_of_search = findNode(k, otree);
    if ( result_of_search == null )
         { answer = null; }
    else { answer = (Record)(result_of_search.value()); }
    return  answer;
  }
 

  /** findNode searches subtree  t  for  k.  */
  private Node findNode(Key k, MutableTree t)
  { Node answer;
    if ( t instanceof Leaf )
         { answer = null; }
    else { Key t_values_key = ((Record)t.value()).getKey();
           if ( k.equals(t_values_key) )
                { answer = (Node)t; }
           else if ( k.lessthan(t_values_key) )
                     { answer = findNode(k, t.left()); }
                else { answer = findNode(k, t.right()); }
         }
    return answer;
  }

  /** delete deletes a record, if it exists, from the ordered tree.
    * @param k - the key of the record to delete
    * @return true, if record deleted successfully; false, if the record with
    *  the key is not present in the tree  */
  public boolean delete(Key k)
  { boolean success;   // remembers if the deletion is a success
    Node target = findNode(k, otree);   // find the Node that holds  k 
    if ( target == null )
         { success = false; }  // nothing to delete!
    else // the  target  Node must be deleted from the ordered tree:
         { Node targets_parent = target.parent();
           // rebuild the subtree rooted by  target  but without its root value:
           MutableTree new_subtree = deleteRootOf(target);
           if ( targets_parent == null )  // is it the root of  otree?
                { otree = new_subtree; } 
           else { if ( targets_parent.left() == target )
                       { targets_parent.setLeft(new_subtree); }
                  else { targets_parent.setRight(new_subtree); }
                }
           success = true;
         }
    return success;
  }

  /** deleteRootOf  removes the root value from tree  t  and returns
    *  the address of the rebuilt tree.
    *  (Note: this coding always replaces the root value with the rightmost
    *   value of the left subtree of  t.   A better coding would alternate
    *   replacing the root value by the leftmost value of the right subtree
    *   of  t.  This is left for you to program.)  */
  private MutableTree deleteRootOf(MutableTree t)
  { MutableTree answer;
    // the first two  tests  check for the trivial case when one of  t's
    //  subtrees is a mere leaf:
    if ( t.left() instanceof Leaf )
          { answer = t.right(); }
    else if ( t.right() instanceof Leaf )
          { answer = t.left(); }
    // else both subtrees are nontrivial, so we will
    // move the rightmost node of  t's  left subtree to the root position:
    else  { Node new_root = findRightmostNodeOf(t.left());
            // connect  new_root  with  t's  right subtree:
            new_root.setRight(t.right());
            t.right().setParent(new_root);

            if ( new_root != t.left() )
               { // remove  new_root  from its old position by 
                 //  (1) Connect its left subtree to its old parent:
                 new_root.parent().setRight(new_root.left());
                 // (2) Connect  new_root  with  t's  left subtree:
                 new_root.setLeft(t.left());
                 t.left().setParent(new_root);
               }
            answer = new_root;
          }
    answer.setParent(t.parent());
    return answer;
  }

  /** finds rightmost node in  t  */
  private Node findRightmostNodeOf(MutableTree t)
  { boolean found = false;
    MutableTree target = t;  // target will hold address of rightmost node
    while ( !found )
          // invariant:  found==true  implies  target is rightmost node
          { if ( target.right() instanceof Leaf )
                 { found = true; }
            else { target = target.right(); }
          }
    return (Node)target;
  }

  /** print prints the tree */
  public void print()
  { otree.printContents(); }
}
