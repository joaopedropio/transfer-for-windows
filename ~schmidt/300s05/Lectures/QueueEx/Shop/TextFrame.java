

package Shop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** TextFrame displays the input view where a user types lines of text
  *   to print */
public class TextFrame extends JFrame
{ JTextField text_field= new JTextField(20);  // the input text_field
  JButton save_button = new JButton("Save");

  /** Constructor TextFrame constructs the view
    * @param my_button - the Save button that causes the typed text to be
    *   saved and ultimately printed.  */
  public TextFrame()
  { Container c = getContentPane();
    c.setLayout(new GridLayout(3,1));
    c.add(new JLabel("Enter text here:"));
      JPanel p2 = new JPanel();
      p2.setLayout(new FlowLayout());
      p2.add(text_field);
    c.add(p2);
       JPanel p3 = new JPanel();
       p3.setLayout(new FlowLayout());
       p3.add(save_button);
    c.add(BorderLayout.SOUTH, p3);
    setTitle("Text Input");
    setSize(400, 200);
    setVisible(true);
  }

  /** connectSaveButton  connects a controller to the frame's Save button
    * @param handler - the controller */
  public void connectSaveButton(ActionListener handler)
  { save_button.addActionListener(handler); }

  /** getText returns the input text typed in the text field
    * @return the text in the text field.  */
  public String getText()
  { String s = text_field.getText(); 
    text_field.setText("");
    return s;
  }
}
