import java.util.Random;
import javax.swing.JOptionPane;

public class Quizfunktionen {
    int streakCounter = 0;
    int punkte = 0;

    Random random = new Random();

    public int zufaelligeFrageNummerAusgeben(Fragen fragen){
        int frageNummer = random.nextInt(MarvelFragen.fragen.length);
        while(fragen.istBereitsBeantwortet(frageNummer) && !fragen.erledigteFragenKategorieMarvel.isEmpty()){
            frageNummer = random.nextInt(MarvelFragen.fragen.length);
            if(!fragen.istBereitsBeantwortet(frageNummer) && fragen.erledigteFragenKategorieMarvel.isEmpty()){
                break;
            }
        }
        return frageNummer;
    }

    public String deckeLoesungAuf(int i, String antwort1, String antwort2, String antwort3, String antwort4){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        if(richtigeAntwort.equals(antwort1)){
            return antwort1;
        }
        else if(richtigeAntwort.equals(antwort2)){
            return antwort2;
        }
        else if(richtigeAntwort.equals(antwort3)){
            return antwort3;
        }
        else{
            return antwort4;
        }
    }

    public String gebeRichtigeAntwort(int i, String antwort1, String antwort2, String antwort3, String antwort4){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        if(richtigeAntwort.equals(antwort1)){
            return "Antwort 1";
        }
        else if(richtigeAntwort.equals(antwort2)){
            return "Antwort 2";
        }
        else if(richtigeAntwort.equals(antwort3)){
            return "Antwort 3";
        }
        else{
            return "Antwort 4";
        }
    }
    //Gibt richtige Lösung zurück, wird deswegen auch für die farbliche Kennzeichung bei falscher/richtiger Antwort verwendet
    public String entferneEineLoesung(int i, String antwort1, String antwort2, String antwort3, String antwort4){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        if(richtigeAntwort.equals(antwort1)){
            return antwort1;
        }
        else if(richtigeAntwort.equals(antwort2)){
            return antwort2;
        }
        else if(richtigeAntwort.equals(antwort3)){
            return antwort3;
        }
        else{
            return antwort4;
        }
    }

    public void verteiltPunkte(boolean b){
        if(b){
            punkte++;
        }
    }

    public String gebePunkteAus(){
        return Integer.toString(punkte);
    }

    public static void popUpAlleFragenBeantwortet(){
        JOptionPane.showMessageDialog(null, "Alle Fragen beantwortet!", "Glückwunsch!", JOptionPane.INFORMATION_MESSAGE);
    }
}
