import java.util.ArrayList;

public class Jautajums {
	String uzdNos;
    String jautajums;
    ArrayList<String> atbVar;
    ArrayList<Integer> atbildes;

    public Jautajums(String uzdNos, String jautajums, ArrayList<String> atbVar, ArrayList<Integer> atbildes) {
        this.uzdNos = uzdNos;
        this.jautajums = jautajums;
        this.atbVar = atbVar;
        this.atbildes = atbildes;
    }
}
