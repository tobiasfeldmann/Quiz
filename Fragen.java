import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Fragen {
    String frage = "";
    String richtigeAntwort = "";

    Set<Integer> erledigteFragenKategorieMarvel = new TreeSet<Integer>();
    QuizMainFrame quizmainframe = new QuizMainFrame();

    public String gebeFrageAus(int i){
        frage = MarvelFragen.fragen[i];
        richtigeAntwort = MarvelFragen.richtigeAntwort[i];
        return frage;
    }

    public void gebeAntwortenAus(int i,JButton[] buttonArray){
        int index = i * 4;
        for(JButton button: buttonArray){
            button.setText(MarvelFragen.antwortenMarvelFragen[index]);
            index++;
        }
    }

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

    public void frageErledigt(int i){
        erledigteFragenKategorieMarvel.add(i);
    }
}
