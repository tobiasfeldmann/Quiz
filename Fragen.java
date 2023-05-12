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
