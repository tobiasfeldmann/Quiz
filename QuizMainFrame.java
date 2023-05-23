import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizMainFrame extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 18);
    final private Font centerFont = new Font("Arial", Font.PLAIN, 24);
    JButton antwort1, antwort2, antwort3, antwort4, kategorieMarvel, kategorieOstfriesland, naechsteFrage, startButton, fiftyfiftyJoker1Button, fiftyfiftyJoker2Button, loesungsButton, eineAntwortRausnehmen1Button, eineAntwortRausnehmen2Button;
    JLabel anzeigeFrage, anzeigePunkte, anzeigeStreak, anzeigeKategorie;
    int temp;
    Color buttonColor;
    boolean falscheAntwort = false;
    JButton[] buttonArray;
    JButton[] buttonsDisablen;

    public void initialize(Fragen fragen, Quizfunktionen quizfunktionen){
        Icon marvel = new ImageIcon("C:/Users/tfgoe/Downloads/Marvel_Comics-logo-D489AEB9C1-seeklogo.com.png", "Marvel Logo");

        //Anzeige der Punkte + longest Streak                                                                                                           *****Punktetafel Anzeige  
        /**
         * Anzeige der erzielten Punkte und der längsten Serie an richtigen Antworten sowie der Kategorie
         *  
         * */                                                                                                             
        anzeigePunkte = new JLabel("Punkte",0);
        anzeigePunkte.setFont(mainFont);

        anzeigeStreak = new JLabel("Streak",0);
        anzeigeStreak.setFont(mainFont);

        anzeigeKategorie = new JLabel("Kategorie", 0);
        anzeigeKategorie.setFont(mainFont);

        //Panel der Punktetafel                                                                                                                             ****Punktetafel Panel
        /**
         * Panel für die Punk-, Kategorie sowie Streakanzeige
         */
        JPanel punktePanel = new JPanel();
        punktePanel.setLayout(new GridLayout(3,1,60,160));
        punktePanel.setOpaque(false);
        punktePanel.add(anzeigeKategorie);
        punktePanel.add(anzeigePunkte);
        punktePanel.add(anzeigeStreak);



        //Anzeige der Kategorie bzw. buttons um hin und her zu wechseln                                                                                     ****Buttons fuer die Kategorien
        /**
         * Button um die Kategorie Marvel zu wählen -> derzeit ohne Funktion
         */
        kategorieMarvel = new JButton(marvel);
        kategorieMarvel.setCursor(new Cursor(HAND_CURSOR));
        kategorieMarvel.setFont(mainFont);
        kategorieMarvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String kategorie = "Marvel";
                String kategorieAlt = fragen.getKategorie();
                anzeigeKategorie.setText(kategorie);
                fragen.setKategorie(kategorie);
                if(!kategorieAlt.equals("kategorie")){
                    temp = quizfunktionen.zufaelligeFrageNummerAusgeben(fragen);
                    anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                    fragen.gebeAntwortenAus(temp, buttonArray);
                }
                quizfunktionen.setzeButtonFarbeZurueck(buttonArray, buttonColor);
            }
        });

        kategorieOstfriesland = new JButton("Ostfriesland");
        kategorieOstfriesland.setCursor(new Cursor(HAND_CURSOR));
        kategorieOstfriesland.setFont(mainFont);
        kategorieOstfriesland.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String kategorieAlt = fragen.getKategorie();
                anzeigeKategorie.setText(kategorieOstfriesland.getText());
                fragen.setKategorie(kategorieOstfriesland.getText()); 
                if(!kategorieAlt.equals("kategorie")){
                    temp = quizfunktionen.zufaelligeFrageNummerAusgeben(fragen);
                    anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                    fragen.gebeAntwortenAus(temp, buttonArray);
                }
                quizfunktionen.setzeButtonFarbeZurueck(buttonArray, buttonColor);
            }
        });

        //Panel für die KategorieButtons                                                                                                                       *****Kategorie Panel
        /**
         * Panel für die Buttons zum wählen der Kategorie
         */
        JPanel kategorienPanel = new JPanel();
        kategorienPanel.setLayout(new GridLayout(1,2,5,50));
        kategorienPanel.setOpaque(false);
        kategorienPanel.add(kategorieMarvel);
        kategorienPanel.add(kategorieOstfriesland);

        buttonColor = kategorieOstfriesland.getBackground();

        //Anzeige Antwortmöglichkeiten                                                                                                                           ***** Anzeige der Frage
        /**
         * Anzeige der aktuellen Frage
         */
        anzeigeFrage = new JLabel("Frage", 0);
        anzeigeFrage.setFont(centerFont);
        
        //Buttons für die Beantwortung der Fragen                                                                                                                *****Antwortbuttons 1 - 4
        /**
         * 4 gleiche Buttons, die die Antwortmöglichkeiten wiedergeben und Methoden zum Vergleichen mit der richtigen Antwort aufrufen
         */
        antwort1 = new JButton("Antwort 1");
        antwort1.setFont(centerFont);
        antwort1.setEnabled(false);
        antwort1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //vergleicht bei Klick die gegebene Antwort mit der richtigen
                quizfunktionen.gebeRichtigeAntwort(temp, buttonArray,0,fragen);
                //aktualisiert die Punkteanzeige
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
                //aktualisiert die Anzeige der Streaks
                quizfunktionen.gebeStreakcounterAus(anzeigeStreak);
            }
        });

        antwort2 = new JButton("Antwort 2");
        antwort2.setFont(centerFont);
        antwort2.setEnabled(false);
        antwort2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.gebeRichtigeAntwort(temp, buttonArray,1,fragen);
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
                quizfunktionen.gebeStreakcounterAus(anzeigeStreak);
            }
        });

        antwort3 = new JButton("Antwort 3");
        antwort3.setFont(centerFont);
        antwort3.setEnabled(false);
        antwort3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.gebeRichtigeAntwort(temp, buttonArray,2,fragen);
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
                quizfunktionen.gebeStreakcounterAus(anzeigeStreak);
            }
        });

        antwort4 = new JButton("Antwort 4");
        antwort4.setFont(centerFont);
        antwort4.setEnabled(false);
        antwort4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.gebeRichtigeAntwort(temp, buttonArray,3,fragen);
                anzeigePunkte.setText(quizfunktionen.gebePunkteAus());
                quizfunktionen.gebeStreakcounterAus(anzeigeStreak);
            }
        });

        /**
         * ButtonArray die die Antwortbuttons zusammenfasst. genutzt für methoden die diese buttons bearbeiten
         */
        buttonArray = new JButton[] {antwort1, antwort2, antwort3, antwort4};
        //AntwortPanel der Antwort Buttons                                                                                                                      *****Antwort Button Panel
        /**
         * Panel für die Antwortbuttons und die Anzeige der Frage
         */
        JPanel antwortButtonPanel = new JPanel();
        antwortButtonPanel.setLayout(new GridLayout(5,1,20,20));
        antwortButtonPanel.setOpaque(false);
        antwortButtonPanel.add(anzeigeFrage);
        antwortButtonPanel.add(antwort1);
        antwortButtonPanel.add(antwort2);
        antwortButtonPanel.add(antwort3);
        antwortButtonPanel.add(antwort4);


        //Joker Panel, Joker Buttons                                                                                                                                        ****Joker Buttons
        /**
         * Fifty Fifty Joker, der die verschiedenen Möglichkeiten auf zwei begrenzt
         */
        fiftyfiftyJoker1Button = new JButton("50/50 Joker");
        fiftyfiftyJoker1Button.setFont(mainFont);
        fiftyfiftyJoker1Button.setEnabled(false);
        fiftyfiftyJoker1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /**
                 * Diese Methode entfernt zwei mögliche, falsche Lösungen
                 * @param temp, index der aktuellen Frage sowie ButtonArray mit den AntwortButtons
                 * */
                quizfunktionen.entferneZweiLoesungen(temp, buttonArray,fragen);
                fiftyfiftyJoker1Button.setEnabled(false);
            }
        });

        /**
         * Fifty Fifty Joker, der die verschiedenen Möglichkeiten auf zwei begrenzt
         */
        fiftyfiftyJoker2Button = new JButton("50/50 Joker");
        fiftyfiftyJoker2Button.setFont(mainFont);
        fiftyfiftyJoker2Button.setEnabled(false);
        fiftyfiftyJoker2Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                /**
                 * Diese Methode entfernt zwei mögliche, falsche Lösungen
                 * @param temp, index der aktuellen Frage sowie ButtonArray mit den AntwortButtons
                 * */
                quizfunktionen.entferneZweiLoesungen(temp, buttonArray,fragen);
                fiftyfiftyJoker2Button.setEnabled(false);
            }
        });
        
        /**
         * Entfernt eine mögliche falsche Antwort
         */
        eineAntwortRausnehmen1Button = new JButton("Entferne eine mögliche Antwort");
        eineAntwortRausnehmen1Button.setFont(mainFont);
        eineAntwortRausnehmen1Button.setEnabled(false);
        eineAntwortRausnehmen1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /**
                 * diese Methode entfernt die falsche Lösung (setzt den Text des entsprechenden Buttons auf "")
                 * @param temp, index der frage und ButtonArray mit den antwortbuttons
                 */
                quizfunktionen.entferneEineLoesung(temp,buttonArray,fragen);
                eineAntwortRausnehmen1Button.setEnabled(false);
            }
        });
        
        /**
         * Entfernt eine mögliche falsche Antwort
         */
        eineAntwortRausnehmen2Button = new JButton("Entferne eine mögliche Antwort");
        eineAntwortRausnehmen2Button.setFont(mainFont);
        eineAntwortRausnehmen2Button.setEnabled(false);
        eineAntwortRausnehmen2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /**
                 * diese Methode entfernt die falsche Lösung (setzt den Text des entsprechenden Buttons auf "")
                 * @param temp, index der frage und ButtonArray mit den antwortbuttons
                 */
                quizfunktionen.entferneEineLoesung(temp, buttonArray,fragen);
                eineAntwortRausnehmen2Button.setEnabled(false); 
            }
        });

        /**
         * Deckt die richtige Lösung auf, bzw. setzt den Text aller anderen Buttons auf ""
         */
        loesungsButton = new JButton("Lösung aufdecken");
        loesungsButton.setFont(mainFont);
        loesungsButton.setEnabled(false);
        loesungsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                /**
                 * Ermittelt den Button mit der richtigen Lösung
                 * @param temp, index der frage und ButtonArray mit den antwortbuttons
                 */
                quizfunktionen.deckeLoesungAuf(temp, buttonArray,fragen);
                loesungsButton.setEnabled(false);
            }
        });

        /**
         * Panel für die Anzeige der verschiedenen Joker
         */
        JPanel jokerButtonPanel = new JPanel();
        jokerButtonPanel.setOpaque(false);
        jokerButtonPanel.setLayout(new GridLayout(5,1,20,20));
        jokerButtonPanel.add(fiftyfiftyJoker1Button);
        jokerButtonPanel.add(fiftyfiftyJoker2Button);
        jokerButtonPanel.add(eineAntwortRausnehmen1Button);
        jokerButtonPanel.add(eineAntwortRausnehmen2Button);
        jokerButtonPanel.add(loesungsButton);

        //Panel South, Start / NaechsteFrage Button plus Panel                                                                                                  *****naechsteFrage Button
        /**
         * Button, der die aktuelle Frage durch eine neue ersetzt, entweder nach richtiger Beantwortung oder wenn man diese aktuell nicht beantworten will
         */
        naechsteFrage = new JButton("Nächste Frage");
        naechsteFrage.setFont(mainFont);
        naechsteFrage.setEnabled(false);
        naechsteFrage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //setzt die Farbe aller Buttons zurück, nachdem diese farbig markiert wurden
                quizfunktionen.setzeButtonFarbeZurueck(buttonArray, buttonColor);
                //gibt eine neue Frage aus und setzt den Text der Anzeige auf die neue Frage
                temp = quizfunktionen.zufaelligeFrageNummerAusgeben(fragen);
                anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                //gibt die neuen Antworten aus
                fragen.gebeAntwortenAus(temp, buttonArray);
                quizfunktionen.naechsteFrageAusgewaehlt(fragen, temp);
                falscheAntwort = false;
            }
        });

        /**
         * ButtonArray das genutzt werden soll, wenn alle Fragen beantwortet wurden, damit man nicht weiter spielt
         */
        buttonsDisablen = new JButton[]{antwort1,antwort2,antwort3,antwort4, naechsteFrage, fiftyfiftyJoker1Button,fiftyfiftyJoker2Button, loesungsButton,eineAntwortRausnehmen1Button,eineAntwortRausnehmen2Button};

        //                                                                                                                                                      ****StartButton
        /**
         * Start Button, der die erste Frage sowie deren Antworten aufruft und die anderen Buttons enabled
         */
        startButton = new JButton("Start!");
        startButton.setFont(mainFont);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                quizfunktionen.startSequenz(buttonsDisablen);
                temp = quizfunktionen.zufaelligeFrageNummerAusgeben(fragen);
                anzeigeFrage.setText(fragen.gebeFrageAus(temp));
                fragen.gebeAntwortenAus(temp, buttonArray);
            }
        });
        //                                                                                                                                                      *****ButtonPanelSouth
        
        /**
         * Panel für den StartButton und den nächsteFrageButton
         */
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
