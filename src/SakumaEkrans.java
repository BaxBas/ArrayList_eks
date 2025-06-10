import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SakumaEkrans {

    public static void main(String[] args) {
        // Izveido logu (JFrame)
        JFrame logs = new JFrame("ArrayList tests");
        logs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logs.setSize(300, 150);
        logs.setLocationRelativeTo(null);

        // Izveido galveno paneli
        JPanel panelis = new JPanel();
        panelis.setLayout(new GridLayout(2, 1, 10, 10)); // 2 rindas, 1 kolonna, atstarpe 10px

        // Poga: Sākt
        JButton startPoga = new JButton("Sākt");
        startPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(logs, "Spēle sāksies!", "Sākt", JOptionPane.INFORMATION_MESSAGE);
                MainDala.main(new String[]{});
            }
        });

        // Poga: Informācija
        JButton infoPoga = new JButton("Informācija");
        infoPoga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(logs, "Šī ir vienkārša viktorīna ar 10 jautājumiem.", "Par spēli", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Pievieno pogas panelim
        panelis.add(startPoga);
        panelis.add(infoPoga);

        // Pievieno paneli logam
        logs.add(panelis);

        // Parāda logu
        logs.setVisible(true);
    }
}
