import java.util.*;
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

    public String[] gebeAntwortenAus(int i){
        int index = i * 4;
        String[] antworten = {
            MarvelFragen.antwortenMarvelFragen[index],
            MarvelFragen.antwortenMarvelFragen[index + 1],
            MarvelFragen.antwortenMarvelFragen[index + 2],
            MarvelFragen.antwortenMarvelFragen[index + 3]
        };
        return antworten;
    }

    public boolean istBereitsBeantwortet(int i){
        if(erledigteFragenKategorieMarvel.contains(i)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean vergleichtAnwortUndFrage(String antwort){
        if(antwort.equals(richtigeAntwort)){
            return true;
        }
        else{
            return false;
        }
    }
}
