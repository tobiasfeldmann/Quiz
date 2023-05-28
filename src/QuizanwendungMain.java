public class QuizanwendungMain {
    public static void main(String[] args){
        Quizfunktionen quizfunktionen = new Quizfunktionen();
        Fragen fragen = new Fragen();
        QuizMainFrame main = new QuizMainFrame();
        main.initialize(fragen, quizfunktionen);
    }
}
