import java.util.Random;

public class Quizfunktionen {
    int anzahlFragen = 0;
    String kategorie = "";
    int punkte = 0;

    Fragen fragen = new Fragen();
    Random random = new Random();

    public void setzeAnzahlFragen(int anzahlFragen){
        this.anzahlFragen = anzahlFragen;
    }

    public void setzeKategorie(String kategorie){
        this.kategorie = kategorie;
    }

    public int zufaelligeFrageNummerAusgeben(){
        int frageNummer = random.nextInt(50);
        while(fragen.istBereitsBeantwortet(frageNummer)){
            frageNummer = random.nextInt(50);
        }
        return frageNummer;
    }
}
