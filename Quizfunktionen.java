import java.util.Random;

public class Quizfunktionen {
    int streakCounter = 0;
    int punkte = 0;

    Fragen fragen = new Fragen();
    Random random = new Random();

    public int zufaelligeFrageNummerAusgeben(){
        int frageNummer = random.nextInt(MarvelFragen.fragen.length);
        while(fragen.istBereitsBeantwortet(frageNummer)){
            frageNummer = random.nextInt(MarvelFragen.fragen.length);
        }
        return frageNummer;
    }

    public void deckeLoesungAuf(int i){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        
    }
}
