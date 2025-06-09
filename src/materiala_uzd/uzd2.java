package materiala_uzd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class uzd2 {

	public static void main(String[] args) {
		//Izveido ArrayList un skeneri
		ArrayList<String> pilsetas = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		//Pilsētu nosakumu ievade
		for(int i=0;i<3;i++) {
			System.out.print("Ievadi "+(i+1)+". pilsētu: ");
			String pilseta = scan.nextLine();
			pilsetas.add(pilseta);
		}
		
		//Aizver skeneri
		scan.close();

		//Izvada sarakstu
		System.out.println("\nPirms kārtošanas:");
		for(int i=0;i<pilsetas.size();i++) {
			System.out.println(pilsetas.get(i));
		}
		
		//Sakārto alfabētiski
		Collections.sort(pilsetas);
		
		//Izvada sarakstu 2.reizi
		System.out.println("\nPēc kārtošanas:");
		for(int i=0;i<pilsetas.size();i++) {
			System.out.println(pilsetas.get(i));
		}
	}
}
