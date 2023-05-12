import java.util.Random;
import java.awt.*;
import javax.swing.*;

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

    public String gebePunkteAus(){
        return Integer.toString(punkte);
    }

    public static void popUpAlleFragenBeantwortet(){
        JOptionPane.showMessageDialog(null, "Alle Fragen beantwortet!", "Glückwunsch!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setzeButtonFarbeZurueck(JButton[] buttonArray, Color color){
        for(JButton button: buttonArray){
            button.setBackground(color);
        }
    }
}
