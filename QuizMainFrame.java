import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizMainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 18);
    JButton antwort1, antwort2, antwort3, antwort4, kategorieMarvel, kategorieOstfriesland;
    JLabel anzeigeFrage;

    public void initialize(Fragen fragen, Quizfunktionen quizfunktionen){



        //Buttons für die Beantwortung der Fragen                                                                                              *****Antwortbuttons
        antwort1 = new JButton("Antwort 1");




        //Main Panel für die Anzeige
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));


        add(mainPanel);


        setTitle("Quiz");
        setSize(1500,890);
        setMinimumSize(new Dimension(850, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
