package materiala_uzd;

import java.util.ArrayList;

public class uzd1 {

	public static void main(String[] args) {
		ArrayList<Integer> skaitli = new ArrayList<>();

		for (int i=1;i<=10;i++) {
			skaitli.add(i);
		}

        System.out.println("Skaitļi lielāki par 5:");
        for (int s:skaitli) {
        	if (s>5)
        		System.out.println(s);
        }
	}
}
