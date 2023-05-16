import java.util.*;
import javax.swing.*;

public class Fragen {
    String frage = "";
    String richtigeAntwort = "";

    Set<Integer> erledigteFragenKategorieMarvel = new TreeSet<Integer>();
    Set<Integer> erledigteFragenKategorieOstfriesland = new TreeSet<Integer>();
    QuizMainFrame quizmainframe = new QuizMainFrame();

    /**
     * gibt eine Frage basierend auf einer zufällig generierten Nummer aus
     * @param i die zufällige Nummer
     * @return die Frage als String
     */
    public String gebeFrageAus(int i){
        frage = MarvelFragen.fragen[i];
        richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        return frage;
    }

    /**
     * setzt die möglichen antworten der aktuellen Frage als Text in die Antwortbuttons
     * @param i index der aktuellen Frage
     * @param buttonArray die jeweiligen antworten
     */
    public void gebeAntwortenAus(int i,JButton[] buttonArray){
        int index = i * 4;
        for(JButton button: buttonArray){
            button.setText(MarvelFragen.antwortenMarvelFragen[index]);
            index++;
        }
    }

    /**
     * überprüft ob die frage bereits beantwortet wurde, vergleich mit dem Set erledigteFragenMarvel
     * @param i index der frage
     * @return boolean, ob die frage beantwortet wurde oder nicht
     */
    public boolean istBereitsBeantwortet(int i){
        Integer iT = Integer.parseInt(Integer.toString(i));
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
    }

    /**
     * fügt den Index einer korrekt beantworteten Fragen zu dem Set erledigteFragenKategorieMarvel hinzu
     * @param i index der aktuellen Frage
     */
    public void frageErledigt(int i){
        erledigteFragenKategorieMarvel.add(i);
    }
}
