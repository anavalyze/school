import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

  
public class JCalculator extends JFrame {
  private JButton[] buttons = new JButton[20];
  private JTextField display = new JTextField();
  private static Font bf = new Font("Arial", Font.PLAIN, 25); 
  private static Font df = new Font("Consolas", Font.BOLD, 40);
  private Calculator rechner = new Calculator();
  
  public JCalculator() {
    super("Rechenknecht");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    
    // Ein konstantes Stringarray für die Button-Beschriftungen
    String[] texte = {"C", "%", "\u00B1", ":", "7", "8", "9", "\u00B7", "4", "5", "6", "-", "1", "2", "3", "+", ",", "0", "\u2190", "="};
    
    // Ein ActionListener als Instanz einer anonymen Listenerklasse für die Buttons
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JButton source = (JButton) ae.getSource();
        char c = source.getText().charAt(0);
        rechner.eingeben(c);
        // System.out.printf("Eingabe: %c%n", c);  // <<< zur Diagnose
        display.setText(rechner.getAusgabe()); 
      }
    };
    
    // Einrichten der Komponenten
    display.setFont(df);
    display.setHorizontalAlignment(JTextField.RIGHT);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(5, 4));
    
    for (int i=0; i<20 ; i++) {
      buttons[i] = new JButton(texte[i]);
      buttons[i].addActionListener(al);
      buttons[i].setFont(bf);
      buttonPanel.add(buttons[i]);
    }
    
    // Einrichten der Oberfläche
    this.setLayout(new BorderLayout());
    this.add(display, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.CENTER);   
    
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new JCalculator();
  }
}
