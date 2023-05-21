import java.util.*;
import javax.swing.*;

public class Fragen {
    String kategorie = "kategorie";
    String frage = "";
    String richtigeAntwort = "";

    Set<Integer> erledigteFragenKategorieMarvel = new TreeSet<Integer>();
    Set<Integer> erledigteFragenKategorieOstfriesland = new TreeSet<Integer>();
    QuizMainFrame quizmainframe = new QuizMainFrame();

    /**
     * gibt eine Frage basierend auf einer zufällig generierten Nummer und der gewählten Kategorie aus
     * @param i die zufällige Nummer
     * @return die Frage als String
     */
    public String gebeFrageAus(int i){
        switch(kategorie){
            case "Marvel":
                frage = MarvelFragen.fragen[i];
                richtigeAntwort = MarvelFragen.richtigeAntwort[i];
                return frage;
            case "Ostfriesland":
                frage = OstfrieslandFragen.fragen[i];
                richtigeAntwort = OstfrieslandFragen.richtigeAntwort[i];
                return frage;
        }
        return "Keine Kategorie ausgewählt";
    }

    /**
     * setzt die möglichen antworten der aktuellen Frage als Text in die Antwortbuttons
     * @param i index der aktuellen Frage
     * @param buttonArray die jeweiligen antworten
     */
    public void gebeAntwortenAus(int i,JButton[] buttonArray){
        int index = i * 4;
        switch(kategorie){
            case "Marvel":
                for(JButton button: buttonArray){
                    button.setText(MarvelFragen.antwortenMarvelFragen[index]);
                    index++;
                }
                break;
            case "Ostfriesland":
                for(JButton button: buttonArray){
                    button.setText(OstfrieslandFragen.antwortenOstfrieslandFragen[index]);
                    index++;
                }
                break;
        }
    }

    /**
     * überprüft ob die frage bereits beantwortet wurde, vergleich mit dem Set erledigteFragenKategorieX, entsprechend der gewählten Kategorie
     * @param i index der frage
     * @return boolean, ob die frage beantwortet wurde oder nicht
     */
    public boolean istBereitsBeantwortet(int i){
        Integer iT = Integer.parseInt(Integer.toString(i));
        switch(kategorie){
            case "Marvel":
                if(erledigteFragenKategorieMarvel.size() == MarvelFragen.fragen.length){
                    Quizfunktionen.popUpAlleFragenBeantwortet();
                    return false;
                }
                else if(erledigteFragenKategorieMarvel.contains(iT)){
                    return true;
                }
                else{
                    return false;
                }
            case "Ostfriesland":
                if(erledigteFragenKategorieOstfriesland.size() == OstfrieslandFragen.fragen.length){
                    Quizfunktionen.popUpAlleFragenBeantwortet();
                    return false;
                }
                else if(erledigteFragenKategorieOstfriesland.contains(iT)){
                    return true;
                }
                else{
                    return false;
                }
        }
        return false;
    }

    /**
     * fügt den Index einer korrekt beantworteten Fragen zu dem Set erledigteFragenKategorieMarvel hinzu
     * @param i index der aktuellen Frage
     */
    public void frageErledigt(int i){
        switch(kategorie){
            case "Marvel":
                erledigteFragenKategorieMarvel.add(i);
                break;
            case "Ostfriesland":
                erledigteFragenKategorieOstfriesland.add(i);
                break;
        }
    }

    /**
     * setzt die Kategorie auf den Inhalt des Buttons
     */
    public void setKategorie(String kategorieX){
        this.kategorie = kategorieX;
        kategorie = kategorie.trim();
    }

    /**
     * gibt die aktuelle Kategorie aus
     */
    public String getKategorie(){
        return this.kategorie;
    }
}  
