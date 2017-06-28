
package Arithmetic;
/** StringReader holds a string and gives away its characters one by one */
public class StringReader
{ /** Field  StringReader.END_CHAR  is the name of the character that
    * is returned when there are no more characters to extract from
    * the string. */
  public static char END_CHAR = 0;

  private String info;              // the string that is disassembled
  private int count = 0;            // how many chars have been given
                                    //  away from the string

  /** Constructor StringReader accepts the string to be disassembled.
    * @param s - the string  */
  public StringReader(String s)
  { info = s; }

  /** nextChar extracts the next unread character from the string it holds
    * @return the next unread char, or return  StringReader.END_CHAR
    *   if there are no more unread characters. */
  public char nextChar()
  { char result;
    if ( count == info.length() )   // no more chars to read?
         { result = END_CHAR; }
    else { result = info.charAt(count);
           count = count + 1;
         }
    return result;
  }
}
