import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Quizfunktionen {
    int streakCounter = 0;
    int punkte = 0;

    Random random = new Random();

    /**
     * gibt eine zufällige Nummer aus, aus der dann die Frage gezogen wird
     * @param fragen
     * @return int der Index der nächsten Frage
    */
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

    /**
     * deckt die richtige Lösung der aktuellen Frage auf
     * @param i der Index der Frage
     * @param buttonArray die AntwortButtons
     */
    public void deckeLoesungAuf(int i, JButton[] buttonArray){
        String richtigeLösung = MarvelFragen.richtigeAntwort[i];
        int richtigerIndex = - 1;
        for(int i1 = 0; i1 < buttonArray.length; i1++){
            if(buttonArray[i1].getText().equals(richtigeLösung)){
                richtigerIndex = i1;
            }
        }
        for(int i2 = 0; i2 < buttonArray.length; i2++){
            if(i2 != richtigerIndex){
                buttonArray[i2].setText("");
            }
        }
    }

    /**
     *gibt die Richtige Antwort aus, falsche werden rot marktiert, die richtige grün
        @param int i, index der Frage; JButton[] buttonArray ein Array der antwort buttons; int buttonIndex der index des buttons   
     */ 
    public void gebeRichtigeAntwort(int i, JButton[] buttonArray, int buttonIndex,Fragen fragen){
        int richtigerButtonIndex = -1;
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        for(int i1 = 0; i1 < buttonArray.length; i1++){
            if(buttonArray[i1].getText().equals(richtigeAntwort)){
                richtigerButtonIndex = i1;
                buttonArray[i1].setBackground(Color.green);
            }
            else{
                buttonArray[i1].setBackground(Color.red);
            }
        }
        if(richtigerButtonIndex == buttonIndex){
            punkte++;
            fragen.frageErledigt(i);
        }
    }


    /**
     * gibt die richtige Lösung zurück, genutzt für den Joker eine Lösung zu entfernen
     * @param int i index der Frage; JButton[] button array das Array mit den Antwortbuttons
     */
    public void entferneEineLoesung(int i, JButton[] buttonArray){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        int richtigerIndex = -1;
        for(int i1 = 0; i1 < buttonArray.length; i1++){
            if(buttonArray[i1].getText().equals(richtigeAntwort)){
                richtigerIndex = i1;
            }
        
        }  
        int zufallsZahl = random.nextInt(3);
        while(zufallsZahl == richtigerIndex || buttonArray[zufallsZahl].getText().equals("")){
            zufallsZahl = random.nextInt(3);
        }
        buttonArray[zufallsZahl].setText("");
    }


    /**
     * entfernt zwei mögliche Antworten für den Fifty Fifty Joker
     * @param i index der Frage,
     * @param buttonArray JButton[] array mit den buttons der antworten
     */
    public void entferneZweiLoesungen (int i, JButton[] buttonArray){
        String richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        int richtigerIndex = -1;
        for(int i1 = 0; i1 < buttonArray.length; i1++){
            if(buttonArray[i1].getText().equals(richtigeAntwort)){
                richtigerIndex = i1;
            }
        }
        int zufallsZahl1 = random.nextInt(3);
        int zufallsZahl2 = random.nextInt(3);
        while(zufallsZahl1 == richtigerIndex || zufallsZahl1 == zufallsZahl2 || zufallsZahl2 == richtigerIndex){
            zufallsZahl1 = random.nextInt(3);
            zufallsZahl2 = random.nextInt(3);
        }
        buttonArray[zufallsZahl1].setText("");
        buttonArray[zufallsZahl2].setText("");
    }

    /**
     * aktualisiert die Punkteanzeige
     * @return String von punkte, die Anzahl der Punkte
     */
    public String gebePunkteAus(){
        return Integer.toString(punkte);
    }

    /**
     * Erzeugt ein PopUp wenn alle Fragen beantwortet sind
     */
    public static void popUpAlleFragenBeantwortet(){
        JOptionPane.showMessageDialog(null, "Alle Fragen beantwortet!", "Glückwunsch!", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * setzt die Farbe der Buttons beim Klicken auf Nächste Frage auf den Standard zurueck
     * @param buttonArray die Antwortbuttons
     * @param color die Standard Color der Buttons
     */
    public void setzeButtonFarbeZurueck(JButton[] buttonArray, Color color){
        for(JButton button: buttonArray){
            button.setBackground(color);
        }
    }
}
