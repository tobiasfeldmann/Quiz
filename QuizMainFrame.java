import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizMainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 18);
    final private Font centerFont = new Font("Arial", Font.PLAIN, 24);
    JButton antwort1, antwort2, antwort3, antwort4, kategorieMarvel, kategorieOstfriesland, naechsteFrage, startButton, fiftyfiftyJoker1Button, fiftyfiftyJoker2Button, loesungsButton, eineAntwortRausnehmen1Button, eineAntwortRausnehmen2Button;
    JLabel anzeigeFrage, anzeigePunkte, anzeigeStreak, anzeigeKategorie;
    int temp;

    public void initialize(Fragen fragen, Quizfunktionen quizfunktionen){

        //Anzeige der Punkte + longest Streak                                                                                                               *****Punktetafel Anzeige  
        anzeigePunkte = new JLabel("Punkte",0);
        anzeigePunkte.setFont(mainFont);

        anzeigeStreak = new JLabel("Streak",0);
        anzeigeStreak.setFont(mainFont);

        anzeigeKategorie = new JLabel("Kategorie", 0);
        anzeigeKategorie.setFont(mainFont);

        //Panel der Punktetafel                                                                                                                             ****Punktetafel Panel
        JPanel punktePanel = new JPanel();
        punktePanel.setLayout(new GridLayout(3,1,60,160));
        punktePanel.setOpaque(false);
        punktePanel.add(anzeigeKategorie);
        punktePanel.add(anzeigePunkte);
        punktePanel.add(anzeigeStreak);



        //Anzeige der Kategorie bzw. buttons um hin und her zu wechseln                                                                                     ****Buttons fuer die Kategorien
        kategorieMarvel = new JButton("     Marvel   ");
        kategorieMarvel.setFont(mainFont);
        kategorieMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                anzeigeKategorie.setText(kategorieMarvel.getText());
            }
        });

        kategorieOstfriesland = new JButton("Ostfriesland");
        kategorieOstfriesland.setFont(mainFont);
        kategorieOstfriesland.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                anzeigeKategorie.setText(kategorieOstfriesland.getText());
            }
        });

        //Panel für die KategorieButtons                                                                                                                       *****Kategorie Panel
        JPanel kategorienPanel = new JPanel();
        kategorienPanel.setLayout(new GridLayout(1,2,5,50));
        kategorienPanel.setOpaque(false);
        kategorienPanel.add(kategorieMarvel);
        kategorienPanel.add(kategorieOstfriesland);



        //Anzeige Antwortmöglichkeiten                                                                                                                           ***** Anzeige der Frage
        anzeigeFrage = new JLabel("Frage", 0);
        anzeigeFrage.setFont(centerFont);

        //Buttons für die Beantwortung der Fragen                                                                                                                *****Antwortbuttons 1 - 4
        antwort1 = new JButton("Antwort 1");
        antwort1.setFont(centerFont);
        antwort1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.verteiltPunkte(fragen.vergleichtAnwortUndFrage(antwort1.getText()));
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
            }
        });

        antwort2 = new JButton("Antwort 2");
        antwort2.setFont(centerFont);
        antwort2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.verteiltPunkte(fragen.vergleichtAnwortUndFrage(antwort2.getText()));
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
                antwort2.setBackground(new Color(128, 128, 255));
            }
        });

        antwort3 = new JButton("Antwort 3");
        antwort3.setFont(centerFont);
        antwort3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.verteiltPunkte(fragen.vergleichtAnwortUndFrage(antwort3.getText()));
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
            }
        });

        antwort4 = new JButton("Antwort 4");
        antwort4.setFont(centerFont);
        antwort4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.verteiltPunkte(fragen.vergleichtAnwortUndFrage(antwort4.getText()));
                /*if(Integer.parseInt(quizfunktionen.gebePunkteAus()) > Integer.parseInt(anzeigePunkte.getText())){
                    antwort4.setBackground(new Color(255,0,0));

                }*/
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
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



        //Joker Panel, Joker Buttons                                                                                                                                        ****Joker Buttons
        fiftyfiftyJoker1Button = new JButton("50/50 Joker");
        fiftyfiftyJoker1Button.setFont(mainFont);
        fiftyfiftyJoker1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String stringTemp = quizfunktionen.deckeLoesungAuf(temp, antwort1.getText(), antwort2.getText(), antwort3.getText(), antwort4.getText());
                System.out.println(stringTemp);
                if(stringTemp.equals(antwort1.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                }
                else if(stringTemp.equals(antwort2.getText())){
                    antwort1.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort3.getText())){
                    antwort1.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort4.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                }
                fiftyfiftyJoker1Button.setEnabled(false);
            }
        });

        fiftyfiftyJoker2Button = new JButton("50/50 Joker");
        fiftyfiftyJoker2Button.setFont(mainFont);
        fiftyfiftyJoker2Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String stringTemp = quizfunktionen.deckeLoesungAuf(temp, antwort1.getText(), antwort2.getText(), antwort3.getText(), antwort4.getText());
                System.out.println(stringTemp);
                if(stringTemp.equals(antwort1.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                }
                else if(stringTemp.equals(antwort2.getText())){
                    antwort1.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort3.getText())){
                    antwort1.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort4.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                }
                fiftyfiftyJoker2Button.setEnabled(false);
            }
        });

        eineAntwortRausnehmen1Button = new JButton("Entferne eine mögliche Antwort");
        eineAntwortRausnehmen1Button.setFont(mainFont);
        eineAntwortRausnehmen1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String stringTemp = quizfunktionen.entferneEineLoesung(temp, antwort1.getText(), antwort2.getText(), antwort3.getText(), antwort4.getText());
                System.out.println(stringTemp);
                if(stringTemp.equals(antwort1.getText())){
                    if(antwort2.getText().equals("")){
                        antwort3.setText("");
                    }
                    antwort2.setText("");
                }
                else if(stringTemp.equals(antwort2.getText())){
                    if(antwort4.getText().equals("")){
                        antwort3.setText("");
                    }
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort3.getText())){
                    if(antwort3.getText().equals("")){
                        antwort2.setText("");
                    }
                    antwort1.setText("");
                }
                else if(stringTemp.equals(antwort4.getText())){
                    if(antwort1.getText().equals("")){
                        antwort2.setText("");
                    }
                    antwort3.setText("");
                }
                eineAntwortRausnehmen1Button.setEnabled(false);
            }
        });

        eineAntwortRausnehmen2Button = new JButton("Entferne eine mögliche Antwort");
        eineAntwortRausnehmen2Button.setFont(mainFont);
        eineAntwortRausnehmen2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String stringTemp = quizfunktionen.entferneEineLoesung(temp, antwort1.getText(), antwort2.getText(), antwort3.getText(), antwort4.getText());
                System.out.println(stringTemp);
                if(stringTemp.equals(antwort1.getText())){
                    if(antwort2.getText().equals("")){
                        antwort3.setText("");
                    }
                    antwort2.setText("");
                }
                else if(stringTemp.equals(antwort2.getText())){
                    if(antwort4.getText().equals("")){
                        antwort3.setText("");
                    }
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort3.getText())){
                    if(antwort3.getText().equals("")){
                        antwort2.setText("");
                    }
                    antwort1.setText("");
                }
                else if(stringTemp.equals(antwort4.getText())){
                    if(antwort1.getText().equals("")){
                        antwort2.setText("");
                    }
                    antwort3.setText("");
                }
                eineAntwortRausnehmen2Button.setEnabled(false); 
            }
        });

        loesungsButton = new JButton("Lösung aufdecken");
        loesungsButton.setFont(mainFont);
        loesungsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String stringTemp = quizfunktionen.deckeLoesungAuf(temp, antwort1.getText(), antwort2.getText(), antwort3.getText(), antwort4.getText());
                System.out.println(stringTemp);
                if(stringTemp.equals(antwort1.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort2.getText())){
                    antwort1.setText("");
                    antwort3.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort3.getText())){
                    antwort2.setText("");
                    antwort1.setText("");
                    antwort4.setText("");
                }
                else if(stringTemp.equals(antwort4.getText())){
                    antwort2.setText("");
                    antwort3.setText("");
                    antwort1.setText("");
                }
                loesungsButton.setEnabled(false);
            }
        });

        JPanel jokerButtonPanel = new JPanel();
        jokerButtonPanel.setOpaque(false);
        jokerButtonPanel.setLayout(new GridLayout(5,1,20,20));
        jokerButtonPanel.add(fiftyfiftyJoker1Button);
        jokerButtonPanel.add(fiftyfiftyJoker2Button);
        jokerButtonPanel.add(eineAntwortRausnehmen1Button);
        jokerButtonPanel.add(eineAntwortRausnehmen2Button);
        jokerButtonPanel.add(loesungsButton);



        //Panel South, Start / NaechsteFrage Button plus Panel                                                                                                  *****naechsteFrage Button
        naechsteFrage = new JButton("Nächste Frage");
        naechsteFrage.setFont(mainFont);
        naechsteFrage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                temp = quizfunktionen.zufaelligeFrageNummerAusgeben();
                anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                antwort1.setText(fragen.gebeAntwortenAus(temp)[0]);
                antwort2.setText(fragen.gebeAntwortenAus(temp)[1]);
                antwort3.setText(fragen.gebeAntwortenAus(temp)[2]);
                antwort4.setText(fragen.gebeAntwortenAus(temp)[3]);
            }
        });
        //                                                                                                                                                      ****StartButton
        startButton = new JButton("Start!");
        startButton.setFont(mainFont);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                temp = quizfunktionen.zufaelligeFrageNummerAusgeben();
                anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                antwort1.setText(fragen.gebeAntwortenAus(temp)[0]);
                antwort2.setText(fragen.gebeAntwortenAus(temp)[1]);
                antwort3.setText(fragen.gebeAntwortenAus(temp)[2]);
                antwort4.setText(fragen.gebeAntwortenAus(temp)[3]);
            }
        });
        //                                                                                                                                                      *****ButtonPanelSouth
        JPanel buttonPanelSouth = new JPanel();
        buttonPanelSouth.setOpaque(false);
        buttonPanelSouth.setLayout(new GridLayout(1,2,5,5));
        buttonPanelSouth.add(startButton);
        buttonPanelSouth.add(naechsteFrage);



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
        //Hinzuefugen des buttonPanelSouth mit Border
        buttonPanelSouth.setBorder(BorderFactory.createEmptyBorder(5,50,10,10));
        mainPanel.add(buttonPanelSouth, BorderLayout.SOUTH);
        //Hinzufügen des jokerButtonPanels in East mit Border
        jokerButtonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,10,10));
        mainPanel.add(jokerButtonPanel, BorderLayout.EAST);


        add(mainPanel);


        setTitle("Quiz");
        setSize(1500,890);
        setMinimumSize(new Dimension(850, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
