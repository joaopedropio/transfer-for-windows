
package Shop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** ColorFrame displays the input frame where the user selects sequences
  *  of colors to print lines of text.  */
public class ColorFrame extends JFrame
{ private JButton red_button = new JButton("Red");
  private JButton blue_button = new JButton("Blue");
  private JButton black_button = new JButton("Black");

  /** Constructor ColorFrame constructs the frame. */
  public ColorFrame()
  { Container c = getContentPane();
    c.setLayout(new FlowLayout());
       c.add(red_button);
       c.add(blue_button);
       c.add(black_button);
    setTitle("Select Color");
    setSize(400, 200);
    setVisible(true);
  }

  /** connectColorButton  connects a controller to a Color button
    * @param c - the color of button
    * @param handler - the controller */
  public void connectSaveButton(Color c, ActionListener handler)
  { if ( c == Color.red )
       { red_button.addActionListener(handler); }
    else if ( c == Color.blue )
       { blue_button.addActionListener(handler); }
    else if ( c == Color.black )
       { black_button.addActionListener(handler); }
    else { throw new RuntimeException("color button init error"); }
  }
}
