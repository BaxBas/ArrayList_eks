import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainDala {
	//globaalie mainiigie
	public static ArrayList<Jautajums> visiJautajumi = new ArrayList<>();
    public static int jautNr = 0;

	public static ArrayList<Integer> izvele = new ArrayList<>();
	
	static void apskatit() {
		try {
			InputStream is = MainDala.class.getResourceAsStream("/jautajumi.txt");
	        if (is == null) {
	            JOptionPane.showMessageDialog(null, "Fails 'jautajumi.txt' nav atrasts!", "Kļūda", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        
	        for(int i=0;i<10;i++) {
	        	String uzdNos;
		        String jautajums;
		        ArrayList<String> atbVar = new ArrayList<>();
		        ArrayList<Integer> atbildes = new ArrayList<>();
		        
		        uzdNos = br.readLine();
		        jautajums = br.readLine();

		        for(int j=0;j<4;j++) {
		        	atbVar.add(br.readLine());
		        }
		        String[] pareizie = br.readLine().split(",");
	
		        for (String s:pareizie) {
		            atbildes.add(Integer.parseInt(s.trim())-1);
		        }
		        
		        visiJautajumi.add(new Jautajums(uzdNos, jautajums, atbVar, atbildes));
	        }
	        br.close();	        
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Radās kļūda, nolasot failu!", "Kļūda", JOptionPane.WARNING_MESSAGE);
	    }
	}

	public static void main(String[] args) {
		apskatit();
		int pareiziArPirmo=0;
		
		String[] iespejas = {"Sākt testu","Informācija"};
		int izv;
		do {
			String izveletais = (String) JOptionPane.showInputDialog(null, "ArrayList tests", "Sākumekrāns", JOptionPane.INFORMATION_MESSAGE, null, iespejas, iespejas[0]);
			izv = Arrays.asList(iespejas).indexOf(izveletais);
			if(izv==1){
				JOptionPane.showMessageDialog(null, "Tests sastāv no 10 jautājumiem, katram jautājumam ir 2-3 pareizās atbildes."
						+ "\nUz nākamo jautājumu var tikt tikai, ja ir atbildēts pareizi."
						+ "\nTesta beigās varēs redzēt uz cik jautājumiem tika atbildēts ar 1.piegājienu."
						+ "\nVeiksmi testā! :D", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			}else if(izv!= JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null, "Programma tiek aizvērta.", "Programmas aizvēršana", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		}while(izv!=0);
		
		for(int i=0;i<10;i++) {
			int piegajieni = 0;
			do {
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
				JLabel jautTeik = new JLabel(visiJautajumi.get(jautNr).jautajums);
				panel.add(jautTeik);
		
				JCheckBox[] checkboxi = new JCheckBox[4];
				for (int j=0; j<4;j++) {
				    checkboxi[j] = new JCheckBox(visiJautajumi.get(jautNr).atbVar.get(j));
				    panel.add(checkboxi[j]);
				}
		
				int rez = JOptionPane.showConfirmDialog(null, panel, visiJautajumi.get(jautNr).uzdNos, JOptionPane.OK_CANCEL_OPTION);
		
				if (rez == JOptionPane.OK_OPTION) {
				    izvele.clear();
				    for (int j=0;j<checkboxi.length;j++) {
				        if (checkboxi[j].isSelected()) {
				            izvele.add(j);
				        }
				    }
		
				    //sakarto alfabeta seciba prieksh salidzinashanas (lai butu pec kartas, nevis kaa tika izveleti checkboxi)
				    Collections.sort(visiJautajumi.get(jautNr).atbildes);
				    Collections.sort(izvele);
				    
				    if (izvele.equals(visiJautajumi.get(jautNr).atbildes)) {
				    	piegajieni++;
				        JOptionPane.showMessageDialog(null, "Pareizi! Ar "+piegajieni+".piegājienu!");
				    } else {
				        JOptionPane.showMessageDialog(null, "Nepareizi, mēģini vēlreiz!");
				        piegajieni++;
				    }
				}else{
					JOptionPane.showMessageDialog(null, "Tests pārtraukts. Programma tiek aizvērta.", "Programmas aizvēršana", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}while(!izvele.equals(visiJautajumi.get(jautNr).atbildes));
			if (piegajieni==1) pareiziArPirmo++;
			jautNr++;
		}
		if(pareiziArPirmo==0)
			JOptionPane.showMessageDialog(null, "Tests beidzies! Ar 1.piegājienu tu atbildēji uz nevienu jautājumu :(");
		else if(pareiziArPirmo==1)
			JOptionPane.showMessageDialog(null, "Tests beidzies! Ar 1.piegājienu tu atbildēji uz "+pareiziArPirmo+" jautājumu!");
		else if(pareiziArPirmo==10)
			JOptionPane.showMessageDialog(null, "Tests beidzies! Ar 1.piegājienu tu atbildēji uz visiem jautājumiem!");
		else
			JOptionPane.showMessageDialog(null, "Tests beidzies! Ar 1.piegājienu tu atbildēji uz "+pareiziArPirmo+" jautājumiem!");
	}
}
