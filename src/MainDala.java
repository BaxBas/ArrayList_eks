import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainDala {
	static void apskatit(String teksts) {
		try {
	        FileReader fr = new FileReader(teksts);
	        BufferedReader br = new BufferedReader(fr);

	        String pirmāRinda = br.readLine();
	        String otrāRinda = br.readLine();
	        br.close();

	        String nolasitais = "";
	        nolasitais += "1. rinda: " + pirmāRinda + "\n";
	        nolasitais += "2. rinda: " + otrāRinda;
	        JOptionPane.showMessageDialog(null, nolasitais, "Faila saturs", JOptionPane.INFORMATION_MESSAGE);
	        
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Radās kļūda, nolasot failu!", "Kļūda", JOptionPane.WARNING_MESSAGE);
	    }
	}

	public static void main(String[] args) {
		apskatit("jautajumi.txt");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel questionLabel = new JLabel("Kura ir pareizā atbilde?");
		panel.add(questionLabel);

		JCheckBox[] checkboxi = new JCheckBox[4];
		String[] options = {"Opcija 1", "Opcija 2", "Opcija 3", "Opcija 4"};

		for (int i=0; i<4; i++) {
		    checkboxi[i] = new JCheckBox(options[i]);
		    panel.add(checkboxi[i]);
		}

		//pareizaas atbildes
		ArrayList<String> pareizi = new ArrayList<>();
		pareizi.add("Opcija 1");
		pareizi.add("Opcija 3");

		int rez = JOptionPane.showConfirmDialog(null, panel, "Jautājums 1", JOptionPane.OK_CANCEL_OPTION);

		if (rez == JOptionPane.OK_OPTION) {
		    ArrayList<String> izvele = new ArrayList<>();
		    for (JCheckBox cb : checkboxi) {
		        if (cb.isSelected()) {
		        	izvele.add(cb.getText());
		        }
		    }

		    //sakarto alfabeta seciba prieksh salidzinashanas (lai butu pec kartas, nevis kaa tika izveleti checkboxi)
		    Collections.sort(pareizi);
		    Collections.sort(izvele);

		    if (izvele.equals(pareizi)) {
		        JOptionPane.showMessageDialog(null, "Pareizi!");
		    } else {
		        JOptionPane.showMessageDialog(null, "Nepareizi!");
		    }
		}
	}
}
