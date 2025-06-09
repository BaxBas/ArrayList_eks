package materiala_uzd;

import java.util.ArrayList;

public class uzd3 {

	public static void main(String[] args) {
		//Izveido sarakstu
		ArrayList<Integer> skaitli = new ArrayList<>();
		
		//Piepilda to ar skaitļiem 1-10
		for (int i=1;i<=10;i++) {
			skaitli.add(i);
		}
		
		//Izdrukā skaitļus ar pārbaudi, 
		//izmantojot for-each cikla īpašības
        System.out.println("Skaitļi lielāki par 5:");
        for (int s:skaitli) {
        	if (s>5)
        		System.out.println(s);
        }
	}
}
