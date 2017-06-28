
package Perm;
import Stack.*;

/** PermGenerator generates all string permutations of the letters,
  *   'a', 'b', 'c', 'd'.  */
public class PermGenerator
{ Stack perms;   // holds the partial permutations.

  /** PermGenerator initializes the permutation generator  */
  public PermGenerator()
  { perms = new Stack(); 
    perms.push("");  // initially, we have the empty string as the only
                     //  partial permutation
  }

  /** generateAllPermsOfABCD  generates the permuations  */
  public void generateAllPermsOfABCD()
  { while ( !perms.isEmpty() )
          { String current = (String)(perms.pop());   // get next partial
                                                      //  permutation
            if ( isFinished(current) )  // is it complete?
                 { System.out.println(current); }
            else  // try to extend it with a next character:
                 { extendAndPush('d', current);  
                   extendAndPush('c', current);
                   extendAndPush('b', current);
                   extendAndPush('a', current);
                 }
          }
    System.out.println("Finished.");
  }

  /** isFinished  announces whether the partial permutation,  s,  is in
    *  fact completed.  */
  private boolean isFinished(String s)
  { return (s.length() == 4 ); }

  /** extendAndPush adds character  c  to the end of string  s,  if  c  is
    *  not already present within  s,  and pushes the new string.  */
  private void extendAndPush(char c, String s)
  { if ( s.indexOf(c) == -1 )  // is char  c  not already in  s ?
       { String new_perm = s + c;   // then append  c  to  s
         perms.push(new_perm);
       }
    // else,  c  is already in  s,  so do nothing.
  }
}

    
