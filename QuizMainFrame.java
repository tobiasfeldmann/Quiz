import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizMainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 18);
    JButton antwort1, antwort2, antwort3, antwort4, kategorieMarvel, kategorieOstfriesland;
    JLabel anzeigeFrage, anzeigePunkte, anzeigeStreak;

    public void initialize(Fragen fragen, Quizfunktionen quizfunktionen){

        //Anzeige der Punkte + longest Streak                                                                                                               *****Punktetafel Anzeigen  
        anzeigePunkte = new JLabel("Punkte",0);
        anzeigePunkte.setFont(mainFont);



        anzeigeStreak = new JLabel("Streak",0);
        anzeigeStreak.setFont(mainFont);


        //Panel der Punktetafel                                                                                                                           ****Punktetafel Panel
        JPanel punktePanel = new JPanel();
        punktePanel.setLayout(new GridLayout(2,1,50,50));
        punktePanel.setOpaque(false);
        punktePanel.add(anzeigePunkte);
        punktePanel.add(anzeigeStreak);


        //Anzeige der Kategorie bzw. buttons um hin und her zu wechseln                                                                                     ****Buttons fuer die Kategorie
        kategorieMarvel = new JButton("Marvel");
        kategorieMarvel.setFont(mainFont);
        kategorieMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });


        kategorieOstfriesland = new JButton("Ostfriesland");
        kategorieOstfriesland.setFont(mainFont);
        kategorieOstfriesland.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        //Panel für die KategorieButtons                                                                                                                       *****Kategorie Panel
        JPanel kategorienPanel = new JPanel();
        kategorienPanel.setLayout(new GridLayout(1,2,5,5));
        kategorienPanel.setOpaque(false);
        kategorienPanel.add(kategorieMarvel);
        kategorienPanel.add(kategorieOstfriesland);





        //Anzeige Antwortmöglichkeiten                                                                                                                           ***** Anzeige der Frage
        anzeigeFrage = new JLabel("Frage", 0);
        anzeigeFrage.setFont(mainFont);

        //Buttons für die Beantwortung der Fragen                                                                                                                *****Antwortbuttons 1 - 4
        antwort1 = new JButton("Antwort 1");
        antwort1.setFont(mainFont);
        antwort1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });


        antwort2 = new JButton("Antwort 2");
        antwort2.setFont(mainFont);
        antwort2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });


        antwort3 = new JButton("Antwort 3");
        antwort3.setFont(mainFont);
        antwort3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });


        antwort4 = new JButton("Antwort 4");
        antwort4.setFont(mainFont);
        antwort4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });

        //AntwortPanel der Antwort Buttons                                                                                                                      *****Antwort Button Panel
        JPanel antwortButtonPanel = new JPanel();

        antwortButtonPanel.setLayout(new GridLayout(5,1,20,20));
        antwortButtonPanel.setOpaque(false);
        antwortButtonPanel.add(anzeigeFrage);
        antwortButtonPanel.add(antwort1);
        antwortButtonPanel.add(antwort2);
        antwortButtonPanel.add(antwort3);
        antwortButtonPanel.add(antwort4);




        //Main Panel für die Anzeige                                                                                                                            ***** Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        //Hinzufuegen des AntwortButtonPanel und Erstellung der Border
        antwortButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 10, 10));
        mainPanel.add(antwortButtonPanel, BorderLayout.CENTER);
        //Hinzufuegen des KategoriePanels mit Border
        kategorienPanel.setBorder(BorderFactory.createEmptyBorder(5,50,10,10));
        mainPanel.add(kategorienPanel, BorderLayout.NORTH);
        //Hinzufuegen des PunktePanels mit Border
        punktePanel.setBorder(BorderFactory.createEmptyBorder(5,50,10,10));
        mainPanel.add(punktePanel, BorderLayout.WEST);
        add(mainPanel);


        setTitle("Quiz");
        setSize(1500,890);
        setMinimumSize(new Dimension(850, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
