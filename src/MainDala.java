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
	//globalie mainiigie
	public static String uzdNos;
	public static String jautajums;
	public static ArrayList<String> atbVar = new ArrayList<>();
	public static ArrayList<Integer> atbildes = new ArrayList<>();
	public static ArrayList<Integer> izvele = new ArrayList<>();
	
	static void apskatit(String teksts) {
		try {
	        FileReader fr = new FileReader(teksts);
	        BufferedReader br = new BufferedReader(fr);

	        uzdNos = br.readLine();
	        jautajums = br.readLine();
	        atbVar.clear();
	        for(int i=0;i<4;i++) {
	        	atbVar.add(br.readLine());
	        }
	        String pareizie = br.readLine();
	        br.close();
	        
	        String[] parts = pareizie.split(",");

	        atbildes.clear();
	        for (String s : parts) {
	            atbildes.add(Integer.parseInt(s.trim())-1);
	        }
	        
	        /*
	        String nolasitais = "";
	        nolasitais += uzdNos;
	        nolasitais += "\n"+jautajums+"\n";
	        for (String variants:atbVar) {
	        	nolasitais += variants+"\n";
	        }
	        nolasitais += atbildes;
	        
	        JOptionPane.showMessageDialog(null, nolasitais, "Faila saturs", JOptionPane.INFORMATION_MESSAGE);*/
	        
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Radās kļūda, nolasot failu!", "Kļūda", JOptionPane.WARNING_MESSAGE);
	    }
	}

	public static void main(String[] args) {
		int piegajieni = 0;
		do {
			apskatit("src/jautajumi.txt");
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
			JLabel jautTeik = new JLabel(jautajums);
			panel.add(jautTeik);
	
			JCheckBox[] checkboxi = new JCheckBox[4];
			for (int i=0; i<4;i++) {
			    checkboxi[i] = new JCheckBox(atbVar.get(i));
			    panel.add(checkboxi[i]);
			}
	
			int rez = JOptionPane.showConfirmDialog(null, panel, uzdNos, JOptionPane.OK_CANCEL_OPTION);
	
			if (rez == JOptionPane.OK_OPTION) {
			    izvele.clear();
			    for (int i=0;i<checkboxi.length;i++) {
			        if (checkboxi[i].isSelected()) {
			            izvele.add(i);
			        }
			    }
	
			    //sakarto alfabeta seciba prieksh salidzinashanas (lai butu pec kartas, nevis kaa tika izveleti checkboxi)
			    Collections.sort(atbildes);
			    Collections.sort(izvele);
			    
			    if (izvele.equals(atbildes)) {
			    	piegajieni+=1;
			        JOptionPane.showMessageDialog(null, "Pareizi! Ar "+piegajieni+".piegājienu!");
			    } else {
			        JOptionPane.showMessageDialog(null, "Nepareizi, mēģini vēlreiz!");
			        piegajieni+=1;
			    }
			}
		}while(!izvele.equals(atbildes));
	}
}
