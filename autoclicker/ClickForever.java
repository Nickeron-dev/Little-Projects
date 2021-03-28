package classes;

// importing one-by-one for optimization
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Robot;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

public class ClickForever implements ActionListener {
  public static boolean isClicking = false;
  JFrame frame;
  JButton button;
  JButton off;
  JTextField repeat;
  JTextField delay;
  JLabel repeatLabel;
  JLabel delayLabel;
  JButton limited;

  public ClickForever() {
    frame = new JFrame("AutoClicker");

    frame.setLayout(new FlowLayout());
    frame.setSize(500, 67);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button = new JButton("ON");
    off = new JButton("OFF");
    repeat = new JTextField("3000", 5);
    delay = new JTextField("10", 5);
    repeatLabel = new JLabel("repeat");
    delayLabel = new JLabel("delay");
    limited = new JButton("Limited");

    button.addActionListener(this);
    off.addActionListener(this);
    limited.addActionListener(this);

    frame.add(repeatLabel);
    frame.add(repeat);
    frame.add(limited);
    frame.add(delayLabel);
    frame.add(delay);
    frame.add(button);
    frame.add(off);

    frame.setVisible(true);
    frame.setResizable(false);
  }

    public void actionPerformed(ActionEvent actionEvent) {
      if (actionEvent.getActionCommand().equals("ON")) {
        isClicking = true; // this variable is checked and used in main() method
      }
      if (actionEvent.getActionCommand().equals("OFF")) {
        isClicking = false; // this variable is checked and used in main() method
      }

      if (actionEvent.getActionCommand().equals("Limited")) {
        pressing();
      }
    }

    public void pressing() {
      try {
        Robot rbt = new Robot();
        Thread.sleep(5000);
        for (int i = 0; i < Integer.parseInt(repeat.getText()); i++) {
  	      // clicking
          rbt.mousePress(InputEvent.BUTTON1_MASK);
          rbt.mouseRelease(InputEvent.BUTTON1_MASK);
          rbt.delay(Integer.parseInt(delay.getText()));
        }
      } catch (java.awt.AWTException exc) {}
      catch (java.lang.InterruptedException exc) {};
    }


  public static void main(String[] args)
          throws java.awt.AWTException, java.lang.InterruptedException {
    ClickForever clickForever = new ClickForever();
    Robot rbt = new Robot();

    while (true) {
      System.out.println("Working"); // without printing smth it doesn't work
      if(isClicking) {
        // clicking
        rbt.mousePress(InputEvent.BUTTON1_MASK);
        rbt.mouseRelease(InputEvent.BUTTON1_MASK);
        rbt.delay(Integer.parseInt(clickForever.delay.getText()));
      }
    }
  }
}
