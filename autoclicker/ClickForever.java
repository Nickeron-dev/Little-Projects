package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickForever implements ActionListener { // implement KeyListener
  public static boolean isClicking = false;
  JFrame frame;
  JButton button;
  JToggleButton off;
  JTextField repeat;
  JTextField delay;
  JLabel repeatLabel;
  JLabel delayLabel;

  public ClickForever() {
    frame = new JFrame("AutoClicker");

    frame.setLayout(new FlowLayout());
    frame.setSize(500, 67);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button = new JButton("ON");
    off = new JToggleButton("OFF");
    repeat = new JTextField("3000", 5);
    delay = new JTextField("10", 5);
    repeatLabel = new JLabel("repeat");
    delayLabel = new JLabel("delay"); 
    
    
    //int leftTimes = Integer.parseInt(repeat.getText());
/*
    button.addKeyListener(this);
    off.addKeyListener(this);
    frame.addKeyListener(this);
    */

    button.addActionListener(this);
    off.addActionListener(this);
	
    frame.add(repeatLabel);
    frame.add(repeat);
    frame.add(button);
    frame.add(off);
    frame.add(delay);
    frame.add(delayLabel);

    frame.setVisible(true);
    frame.setResizable(false);
  }

    public void actionPerformed(ActionEvent actionEvent) {
      System.out.println(actionEvent.getActionCommand());
      if (actionEvent.getActionCommand().equals("ON")) {
        isClicking = true;
        pressing();
        System.out.println("ON here");
      }
      if (actionEvent.getActionCommand().equals("OFF")) {
        isClicking = false;
        System.out.println("OFF here");
      }

    }
/*
    public void keyPressed(KeyEvent event) {
      System.out.println("Pressed");
      if (event.getKeyCode() == KeyEvent.VK_K) {
        System.out.println("KKKeeKK");
        isClicking = false;
      }
    }

    public void keyReleased(KeyEvent event) {
      System.out.println("Released");
      if (event.getKeyCode() == KeyEvent.VK_K) {
        System.out.println("K was Released");
        isClicking = false;
      }
    }

    public void keyTyped(KeyEvent event) {
      System.out.println("Typed");
    }
*/

    public void pressing() {
      try {
        Robot rbt = new Robot();
        System.out.println("isclick: " + isClicking);
        while (isClicking) {
          Thread.sleep(5000);
          //if(!frame.isActive()) {
          for (int i = 0; i < Integer.parseInt(repeat.getText()); i++) {
	      // clicking
              rbt.mousePress(InputEvent.BUTTON1_MASK);
              rbt.mouseRelease(InputEvent.BUTTON1_MASK);
              rbt.delay(Integer.parseInt(delay.getText()));
            }

            //}
          //  if(actionEvent.getActionCommand().equals("OFF")) {
          //    System.out.println("Heree");
          //    isClicking = false;
          //    return;
          //  }
            return;
        }
      } catch (Exception exc) {};
    }


  public static void main(String[] args)
          throws java.awt.AWTException, java.lang.InterruptedException {
    ClickForever clickForever = new ClickForever();
    Robot rbt = new Robot();

    //clickForever.createFrame();
    System.out.println("isclick: " + isClicking);
    while (true) {
        if(isClicking) {
          rbt.mousePress(InputEvent.BUTTON1_MASK);
          rbt.mouseRelease(InputEvent.BUTTON1_MASK);
          rbt.delay(1000);
        }
      //  if(!isClicking) {};
    }
  }
}
