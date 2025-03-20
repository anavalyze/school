// benötigte Pakate (Color könnte man auch weglassen, ist nur für die vordefinierte graue Farbe drinn)
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

// gewünschte Klasse, sollte immer von JFrame abgeleitet sein
public class SwingBeispiel extends JFrame {  

    public SwingBeispiel(){
        // Bedienelemente für die Benutzeroberfläche anlegen
        JFrame f = new JFrame();
        JButton b = new JButton("Antwort testen");
        JLabel la1 = new JLabel("Wie viele Meter ist der Fernsehturm hoch?");
        JLabel la2 = new JLabel("");
        JTextField t = new JTextField();

        // Position und Größe der Bedienelemente festlegen
        b.setBounds(100,100,200, 40);
        la1.setBounds(50, 50, 300,30);
        la2.setBounds(50, 200, 100,30);
        t.setBounds(50, 160, 300, 30);
          
        // wichtig: Bedienelemente dem Frame hinzufügen (sonst tauchen sie nicht auf)
        f.add(b);
        f.add(la1);
        f.add(la2);
        f.add(t);
        
        // den Frame mit einigen nützlichen Basiswerten initialisieren
        f.setSize(400,500);
        f.setBackground(Color.DARK_GRAY);
        f.setLayout(null);
        f.setVisible(true);

        // einen ActionListener an den Button anhängen: hier wird festgelegt, wie sich ein Objekt bei einem Ereignis verhalten soll
        b.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                if (t.getText().equals("368")) {
                    la2.setText("Richtig!");
                } else {
                    la2.setText("Falsch!");
                }
            }
        });
    }



    public static void main(String[] args) {  // Testlauf ...
         new SwingBeispiel();
    }
}  