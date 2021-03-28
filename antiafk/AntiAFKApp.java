package src;

import java.awt.FlowLayout;
import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AntiAFKApp implements ActionListener {
  public static boolean isON = false;
  private JFrame frame;
  private JButton on;
  private JButton off;

  public AntiAFKApp() {
    frame = new JFrame("Anti AFK");

    frame.setLayout(new FlowLayout());
    frame.setSize(250, 70);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    on = new JButton("ON");
    off = new JButton("OFF");

    on.addActionListener(this);
    off.addActionListener(this);

    frame.add(on);
    frame.add(off);

    frame.setVisible(true);
    frame.setResizable(false);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("ON")) {
      isON = true;
    }
    if (event.getActionCommand().equals("OFF")) {
      isON = false;
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new AntiAFKApp();
      }
    });
    try {
      Robot clicker = new Robot();

      for ( ;; ) {
        System.out.println("Working"); // doesn't work without it
        if (isON) {
          clicker.keyPress(KeyEvent.VK_W);
          clicker.keyRelease(KeyEvent.VK_W);
          clicker.delay(100);
          clicker.keyPress(KeyEvent.VK_S);
          clicker.keyRelease(KeyEvent.VK_S);
          clicker.delay(30000);
        }
      }
    } catch (AWTException exc) {}

  }
}
