package materiala_uzd;

import java.util.ArrayList;

public class uzd1 {

	public static void main(String[] args) {
		// 1.Izveido sarakstu ar 5 produktiem
        ArrayList<String> produkti = new ArrayList<>();
        produkti.add("Maize");
        produkti.add("Piens");
        produkti.add("Siers");
        produkti.add("Tomāti");
        produkti.add("Mellenes");

        System.out.println("Sākotnējais saraksts:");
        System.out.println(produkti);

        // 2.Izņem pirmo produktu
        produkti.remove(0); // 1.produkta indekss ir 0, izņem "Maize"

        System.out.println("\nPēc pirmā produkta izņemšanas:");
        System.out.println(produkti);

        // 3.Izdrukā produktu ar indeksu 3
        System.out.println("\nProdukts ar indeksu 3:");
        System.out.println(produkti.get(3));

        // 4.Nomaini produktu ar indeksu 2 uz “Zemenes”
        produkti.set(2,"Zemenes");

        System.out.println("\nPēc aizvietošanas ar \"Zemenes\":");
        System.out.println(produkti);

        // 5.Izdrukā saraksta lielumu
        System.out.println("\nSaraksta lielums: "+produkti.size());
	}
}
