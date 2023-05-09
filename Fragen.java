import java.util.*;
public class Fragen {
    String frage = "";
    Set<Integer> erledigteFragenKategorieMarvel = new TreeSet<Integer>();
    List<String> richtigeAntwortKategorieMarvel = new ArrayList<String>();
    String[][] moeglichkeitenKategorieX = new String[50][4];
    Map<Integer, String> fragenKategorieMarvel = new HashMap<Integer, String>();

    public void initialisierefragenKategorieMarvel(){
        fragenKategorieMarvel.put(0, "Welche Farbe hat der Seelenstein?");
        richtigeAntwortKategorieMarvel.add("Orange");
        moeglichkeitenKategorieX[0][0] = "Blau";
        moeglichkeitenKategorieX[0][1] = "Grün";
        moeglichkeitenKategorieX[0][2] = "Orange";
        moeglichkeitenKategorieX[0][3] = "Rot";

        fragenKategorieMarvel.put(1, "Auf welchem Planeten befand sich der Seelenstein?");
        richtigeAntwortKategorieMarvel.add("Vormir");
        moeglichkeitenKategorieX[1][0] = "Erde";
        moeglichkeitenKategorieX[1][1] = "Titan";
        moeglichkeitenKategorieX[1][2] = "Nowhere";
        moeglichkeitenKategorieX[1][3] = "Vormir";

    }

    public String gebeFrageAus(int i){
        System.out.println(fragenKategorieMarvel.get(i));
        System.out.println(moeglichkeitenKategorieX[i][0]);
        System.out.println(moeglichkeitenKategorieX[i][1]);
        System.out.println(moeglichkeitenKategorieX[i][2]);
        System.out.println(moeglichkeitenKategorieX[i][3]);
        System.out.println(richtigeAntwortKategorieMarvel.get(i));
        return frage;
    }

    public boolean istBereitsBeantwortet(int i){
        if(erledigteFragenKategorieMarvel.contains(i)){
            return true;
        }
        else{
            return false;
        }
    }
}
