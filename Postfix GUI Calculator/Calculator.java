import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.EmptyStackException;

class ControlPanel extends JPanel
{
   Font f;
   public ControlPanel(Frame frame)
   {
      f = new Font("Courier New", Font.BOLD, 42);
      setBackground(Color.BLUE);
      setLayout(new GridLayout(4, 2));
      String[] operators = {"*", "/", "+", "-", "^", "%", "SPACE", "ABOUT"};
      for( int i=0; i<8; i++ ) 
      {
         JButton jb;
         jb = new JButton(operators[i]);
         jb.setSize(32,32);
         jb.setBackground(new Color(255,165,0));
         jb.setForeground(Color.BLACK);
         jb.setPreferredSize(new Dimension(32,32));
         if( i>=6 ){ 
            f = new Font("Courier New", Font.BOLD, 18);
         }   
         jb.setFont(f);
         jb.addActionListener(frame);
         add(jb);
      }
   }
}
class NumberPanel extends JPanel
{
   Font f;
   public NumberPanel(Frame frame)
   {
      f = new Font("Courier New", Font.BOLD, 42);
      setSize(400, 320);
      setPreferredSize(new Dimension(400, 320));
      setBackground(Color.YELLOW);
      setLayout(new GridLayout(4, 3));
      
      String[] labels = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "C", "0", "="};

      for( int i=0; i<12; i++ ) 
      {
         JButton jb;
         jb = new JButton(labels[i]);
         jb.setSize(40,40);
         jb.setPreferredSize(new Dimension(40,40));
         jb.setFont(f);
         jb.addActionListener(frame);
         add(jb);
      }
   }
}
class DisplayPanel extends JPanel
{
   public JTextField textField;
   public Font f;
   public DisplayPanel()
   {
      f = new Font("Courier New", Font.BOLD, 32);
      textField = new JTextField("0");
      textField.setFont(f);
      textField.setHorizontalAlignment(SwingConstants.RIGHT);
      textField.setBounds(20, 20, 560, 80);
      textField.setSize(new Dimension(540, 80));
      textField.setPreferredSize(new Dimension(540, 80));
      textField.setBackground(Color.WHITE);
      Border border = BorderFactory.createLineBorder(Color.BLACK);
      textField.setBorder(border);
      textField.setForeground(Color.BLACK);
      textField.setText("0");
      this.add(textField);
   }
   public void paint(Graphics g)
   {
      super.paint(g);
   }
}

class Frame extends JFrame implements ActionListener
{
   NumberPanel   numberPanel;
   ControlPanel   controlPanel;
   DisplayPanel   displayPanel;
   JTextField     textField;

   public Frame()
   {
      numberPanel = new NumberPanel(this);
      controlPanel = new ControlPanel(this);
      controlPanel.setPreferredSize(new Dimension(200, 380));      
      controlPanel.setSize(new Dimension(200, 380));      
      displayPanel = new DisplayPanel();
      displayPanel.setPreferredSize(new Dimension(600, 100));
      displayPanel.setBackground(new Color(0,0,200));
      add(numberPanel, BorderLayout.WEST);                  
      add(controlPanel, BorderLayout.EAST);   
      add(displayPanel, BorderLayout.NORTH);   
      pack();          
   }
   
   public void paint(Graphics g)
   {
      super.paint(g);
      //System.out.println(getWidth() + ", " + getHeight());
   }
   public void actionPerformed(ActionEvent ae)
   {
      String cmd = ae.getActionCommand();
      if(ae.getActionCommand().equals("="))
      {
         Stack s = new Stack();
         PostfixEvaluator result = new PostfixEvaluator(); 
         try{
             String num = displayPanel.textField.getText();
             JOptionPane p = new JOptionPane();
             displayPanel.textField.setText(Integer.toString(result.evaluate(num)));
             
             //p.showMessageDialog(this, result.evaluate(displayPanel.textField.getText()), 
                               //      " ", JOptionPane.PLAIN_MESSAGE);
         }
         catch (PostfixException e)
         {
             JOptionPane p = new JOptionPane();
             p.showMessageDialog(this, "malformed", 
                                     " ", JOptionPane.PLAIN_MESSAGE);
         }    
        
         return;
      }
      /* about */
      if( cmd.equals("ABOUT") )
      {
         JOptionPane p = new JOptionPane();
         p.showMessageDialog(this, "This calculator solves reverse notation equations.\n"  
                                + "enter 2 3 * 6 + = \nThe result will be 12", 
                                 "Calculator Projct by Daniel Malis", 
                                 JOptionPane.PLAIN_MESSAGE);
         return;
      }
      if( cmd.equals("C") ) 
      {
         displayPanel.textField.setText("0");
         return;
      }
      if( cmd.length() == 1 && !Character.isDigit(cmd.charAt(0)) ) 
      {
         cmd = " " + cmd + " ";
      }
      if(cmd.equals("SPACE") )
      {
         cmd = " ";
      }
      
      /* add character to display */
      if( displayPanel.textField.getText().equals("0"))
      {
         displayPanel.textField.setText(cmd);
      }
      else
      {
         displayPanel.textField.setText(displayPanel.textField.getText() 
                  + cmd );
      }
   }
}

public class Calculator
{
   Frame frame;
   NumberPanel    numberPanel;
   ControlPanel   controlPanel;
   DisplayPanel   displayPanel;
   JTextField     textField;
   
   public Calculator()
   {
      frame = new Frame();
      frame.setTitle("Calculator Project");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setLayout(new BorderLayout());
      frame.setVisible(true);
   }
   public static void main(String[] args)
   {
      Calculator c = new Calculator();
   }
}