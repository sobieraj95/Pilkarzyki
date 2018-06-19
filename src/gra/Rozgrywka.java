    package gra;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Rozgrywka extends JFrame implements KeyListener {

    final double czas_rundy = 1000;
    public ObszarGry obszargry = new ObszarGry();
    double czas_gracz1 = czas_rundy;
    double czas_gracz2 = czas_rundy;
    double milisekundy;
    double mili;
    String czas;
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (obszargry.aktualnygraczjestczerwony) {
                czas_gracz1--;
                mili = czas_gracz1 / 10;
                czas = "" + mili;
                czas_gracza1.setText(czas);

            } else {
                czas_gracz2--;
                mili = czas_gracz2 / 10;
                czas = "" + mili;
                czas_gracza2.setText(czas);

            }
            if (czas_gracz1 <= 0) {
                KoniecGry(2);
            }
            if (czas_gracz2 <= 0) {
                KoniecGry(1);
            }
        }
    };

    //obiekt obszaru gry
    public ArrayList<PrzebiegGry> przebieggry; //tablica przechowująca obiekty przebiegu gry (kolejne po sobie ruchy)
    ArrayList<Integer> goraplanszy; //tablica, która przechowuje pozycje góry planszy
    ArrayList<Integer> dolplanszy;  //tablica, która przechowuje pozycje dołu planszy
    ArrayList<Integer> lewoplanszy; //tablica, która przechowuje pozycje lewa planszy
    ArrayList<Integer> prawoplanszy; //tablica, która przechowuje prawo pozycje prawa planszy

    ArrayList<Integer> graniceplanszy; //tablica, która przechowuje wszystkie granice planszy

    ArrayList<Integer> wykorzystanepozycje; //wykorzystane pozycje, potrzebne do sprawdzania, czy można się "odbić" od jakiegoś ruchu
    ArrayList<Integer> bramka1; //miejsca bramek
    ArrayList<Integer> bramka2;

    boolean liniajestczerwona = true; //na poczatku ustawiamy czerwoną linię jako poczatek gry

    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public int pozycja; //zmienna przechowująca aktualną pozycję na planszy
    public boolean trwarozgrywka;

    public Rozgrywka() {
        initComponents();
        nazwa_gracza1.setText(gra.Pilkarzyki.nazwapierwszegogracza);
        nazwa_gracza2.setText(gra.Pilkarzyki.nazwadrugiegogracza);

        start_stoper();
        //getContentPane().setBackground(Color.white); //ustawiamy białe tło 
        obszargry.setSize(400, 400);
        obszargry.setLocation(200, 0);
        add(obszargry);
        gra.Pilkarzyki.wynikpierwszegogracza = 0;
        gra.Pilkarzyki.wynikdrugiegogracza = 0;
        PrzygotujRozgrywke();
        test.addKeyListener(this);
        test.requestFocus();

    }

    public void PrzygotujRozgrywke() {
        pozycja = 65; //początkową pozycją na planszy jest 65

        if (obszargry.aktualnygraczjestczerwony == true) {
            setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
        } else {
            setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
        }
        przebieggry = new ArrayList<PrzebiegGry>(); //inicjalizujemy kolekcje odpowiednimi danymi

        //pozycje na planszy ograniczone rozmiarem (aby nie można było wyjść poza granice planszy)
        goraplanszy = new ArrayList<Integer>(Arrays.asList(111, 112, 113, 117, 118, 119));
        dolplanszy = new ArrayList<Integer>(Arrays.asList(11, 12, 13, 17, 18, 19));
        lewoplanszy = new ArrayList<Integer>(Arrays.asList(111, 101, 91, 81, 71, 61, 51, 41, 31, 21, 11));
        prawoplanszy = new ArrayList<Integer>(Arrays.asList(119, 109, 99, 89, 79, 69, 59, 49, 39, 29, 19));
        wykorzystanepozycje = new ArrayList<Integer>(Arrays.asList(65));
        graniceplanszy = new ArrayList<Integer>(Arrays.asList(114, 116, 14, 16, 111, 112, 113, 117, 118, 119, 11, 12, 13, 17, 18, 19, 111, 101, 91, 81, 71, 61, 51, 41, 31, 21, 11,119, 109, 99, 89, 79, 69, 59, 49, 39, 29, 19));
        bramka1 = new ArrayList<Integer>(Arrays.asList(124, 125, 126));
        bramka2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
        liniajestczerwona = true;
        obszargry.aktualnygraczjestczerwony = true;

        //ustawiamy współrzędne środka planszy, jako wartości początkowe
        x1 = 200;
        x2 = 200;
        y1 = 200;
        y2 = 200;
        wynik_gracza1.setText(String.valueOf(gra.Pilkarzyki.wynikpierwszegogracza));
        wynik_gracza2.setText(String.valueOf(gra.Pilkarzyki.wynikdrugiegogracza));
        //poniższe instrukcje są potrzebne do nowej gry, po zakończeniu poprzedniej
        obszargry.linie.clear(); //zerujemy linie w obszarze gry
        obszargry.repaint(); //odświeżamy obszar gry
        milisekundy = 0;
        trwarozgrywka = true;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        test = new javax.swing.JTextField();
        przyciskZakonczRozgrywke = new javax.swing.JButton();
        czas_gracza1 = new javax.swing.JTextField();
        czas_gracza2 = new javax.swing.JTextField();
        nazwa_gracza1 = new javax.swing.JLabel();
        nazwa_gracza2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wynik_gracza1 = new javax.swing.JLabel();
        wynik_gracza2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(133, 174, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(800, 430));
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        test.setMinimumSize(new java.awt.Dimension(600, 630));
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });
        getContentPane().add(test);
        test.setBounds(0, 400, 6, 0);

        przyciskZakonczRozgrywke.setText("Zakończ rozgrywkę");
        przyciskZakonczRozgrywke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przyciskZakonczRozgrywkeActionPerformed(evt);
            }
        });
        getContentPane().add(przyciskZakonczRozgrywke);
        przyciskZakonczRozgrywke.setBounds(630, 220, 160, 30);

        czas_gracza1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        czas_gracza1.setForeground(new java.awt.Color(255, 153, 153));
        czas_gracza1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        czas_gracza1.setText("100.0");
        czas_gracza1.setOpaque(false);
        czas_gracza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czas_gracza1ActionPerformed(evt);
            }
        });
        getContentPane().add(czas_gracza1);
        czas_gracza1.setBounds(20, 110, 160, 30);

        czas_gracza2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        czas_gracza2.setForeground(new java.awt.Color(255, 153, 153));
        czas_gracza2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        czas_gracza2.setText("100.0");
        czas_gracza2.setOpaque(false);
        czas_gracza2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czas_gracza2ActionPerformed(evt);
            }
        });
        getContentPane().add(czas_gracza2);
        czas_gracza2.setBounds(620, 110, 160, 30);

        nazwa_gracza1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        nazwa_gracza1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nazwa_gracza1.setText("Gracz1");
        nazwa_gracza1.setPreferredSize(new java.awt.Dimension(160, 14));
        getContentPane().add(nazwa_gracza1);
        nazwa_gracza1.setBounds(20, 20, 160, 30);

        nazwa_gracza2.setText(gra.Pilkarzyki.nazwapierwszegogracza);
        nazwa_gracza2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        nazwa_gracza2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nazwa_gracza2.setText("Gracz2");
        getContentPane().add(nazwa_gracza2);
        nazwa_gracza2.setBounds(620, 20, 160, 30);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pozostały czas ! ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(620, 80, 160, 20);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pozostały czas ! ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 160, 20);

        wynik_gracza1.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        wynik_gracza1.setForeground(new java.awt.Color(255, 0, 0));
        wynik_gracza1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wynik_gracza1.setText("0");
        getContentPane().add(wynik_gracza1);
        wynik_gracza1.setBounds(0, 300, 200, 100);

        wynik_gracza2.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        wynik_gracza2.setForeground(new java.awt.Color(0, 0, 255));
        wynik_gracza2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wynik_gracza2.setText("0");
        getContentPane().add(wynik_gracza2);
        wynik_gracza2.setBounds(600, 300, 200, 100);

        jLabel4.setBackground(new java.awt.Color(255, 103, 250));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tlo_bok1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 200, 400);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tlo_bok1.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(600, 0, 200, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void przyciskZakonczRozgrywkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przyciskZakonczRozgrywkeActionPerformed

        AlgorytmKomputera.isRunning = false; //jeśli działa algorytm komputera to go zatrzymujemy

        gra.Pilkarzyki.gracze[0].ZwiekszStraconeBramki(gra.Pilkarzyki.wynikdrugiegogracza);
        gra.Pilkarzyki.gracze[0].ZwiekszZdobyteBramki(gra.Pilkarzyki.wynikpierwszegogracza);

        gra.Pilkarzyki.gracze[1].ZwiekszStraconeBramki(gra.Pilkarzyki.wynikpierwszegogracza);
        gra.Pilkarzyki.gracze[1].ZwiekszZdobyteBramki(gra.Pilkarzyki.wynikdrugiegogracza);

        gra.Pilkarzyki.lista.ZaktualizujWynik(gra.Pilkarzyki.nazwapierwszegogracza, gra.Pilkarzyki.gracze[0]);
        gra.Pilkarzyki.lista.ZaktualizujWynik(gra.Pilkarzyki.nazwadrugiegogracza, gra.Pilkarzyki.gracze[1]);

        try {
            gra.Pilkarzyki.lista.ZapiszListe();
        } catch (IOException ex) {
            Logger.getLogger(Rozgrywka.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();

    }//GEN-LAST:event_przyciskZakonczRozgrywkeActionPerformed

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testActionPerformed

    private void czas_gracza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czas_gracza1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_czas_gracza1ActionPerformed

    private void czas_gracza2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czas_gracza2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_czas_gracza2ActionPerformed

    private void KoniecGry(int ktorygracz) {
        trwarozgrywka = false;
        czas_gracz1 = czas_rundy;
        czas_gracz2 = czas_rundy;
        if (ktorygracz == 1) {
            gra.Pilkarzyki.wynikpierwszegogracza++;
            JOptionPane.showMessageDialog(null, "Gracz " + gra.Pilkarzyki.nazwapierwszegogracza + " zdobył punkt!");
        } else if (ktorygracz == 2) {
            gra.Pilkarzyki.wynikdrugiegogracza++;
            JOptionPane.showMessageDialog(null, "Gracz " + gra.Pilkarzyki.nazwadrugiegogracza + " zdobył punkt!");
        } else {
            if (obszargry.aktualnygraczjestczerwony) {
                gra.Pilkarzyki.wynikdrugiegogracza++;
                JOptionPane.showMessageDialog(null, "Gracz " + gra.Pilkarzyki.nazwadrugiegogracza + " zdobył punkt!");
            } else {
                gra.Pilkarzyki.wynikpierwszegogracza++;
                JOptionPane.showMessageDialog(null, "Gracz " + gra.Pilkarzyki.nazwapierwszegogracza + " zdobył punkt!");
            }
        }

        PrzygotujRozgrywke();

    }

    public boolean RuchLewo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry(); //tworzymy nowy ruch przebiegu gry, który będzie wpisany jako następny
        przebiegtmp.poczatek = pozycja; //początek nowego ruchu jest bieżącą pozycją
        przebiegtmp.koniec = pozycja - 1; //koniec nowego ruchu jest nową pozycją na planszy

        /*sprawdzamy czy można wykonać taki ruch
        warunki do spelnienia możliwości wykonania ruchu:
        -nie można powtórzyć już wykonanego ruchu (przebieggry nie może zawierać nowego ruchu który próbowaliśmy stworzyć)
        -nie możemy znajdować się na pozycjach na granicy planszy (np. znajdować się na lewym konturze i iść w lewo)
        
         */
        if (!przebieggry.contains(przebiegtmp) && !lewoplanszy.contains(pozycja) && !dolplanszy.contains(pozycja) && !goraplanszy.contains(pozycja) && pozycja != 14 && pozycja != 114) {
            //jeśli można wykonać ruch to przesuwamy pozycje na planszy i dodajemy nowy ruch do przebiegu gry
            pozycja -= 1;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia(); //tworzymy nową linię do zapisania dla obszarugry

            x2 -= 25; //przesuwamy współrzędną nowej o kratkę np. w lewo

            //zapisujemy współrzędne bieżącego punktu do nowej linii i dodajemy ją do listy linii dla obszaru gry
            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;

            obszargry.repaint(); //odświeżamy planszę

            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }

            return true;

        } else {
            //jeśli nie udało się wykonać ruchu, to jest możliwość, że nie ma już żadnego ruchu i trzeba to sprawdzić
            if (CzyZablokowany()) { //jeśli wystąpiło zablokowanie, to kończymy grę

                KoniecGry(3);
            }
            return false;
        }
    }

    public boolean RuchPrawo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja + 1;

        if (!przebieggry.contains(przebiegtmp) && !prawoplanszy.contains(pozycja) && !dolplanszy.contains(pozycja) && !goraplanszy.contains(pozycja) && pozycja != 16 && pozycja != 116) {
            pozycja += 1;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            x2 += 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchGora() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja + 10;

        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 114 && pozycja != 116) {
            pozycja += 10;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            y2 -= 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            y1 = y2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchDol() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja - 10;

        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 14 && pozycja != 16) {
            pozycja -= 10;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            y2 += 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            y1 = y2;
            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }

            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }

            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchDolLewo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja - 11;

        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && pozycja != 11 && pozycja != 14) {
            pozycja -= 11;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            x2 -= 25;
            y2 += 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;
            y1 = y2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchDolPrawo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja - 9;

        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 16 && pozycja != 19) {
            pozycja -= 9;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            x2 += 25;
            y2 += 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;
            y1 = y2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchGoraLewo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja + 9;

        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && pozycja != 111 && pozycja != 114) {
            pozycja += 9;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            x2 -= 25;
            y2 -= 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;
            y1 = y2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę

                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }

    }

    public boolean RuchGoraPrawo() {
        if (!trwarozgrywka) {
            return false;
        }
        PrzebiegGry przebiegtmp = new PrzebiegGry();
        przebiegtmp.poczatek = pozycja;
        przebiegtmp.koniec = pozycja + 11;

        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 116 && pozycja != 119) {
            pozycja += 11;
            przebieggry.add(przebiegtmp);

            Linia tmp = new Linia();

            x2 += 25;
            y2 -= 25;

            tmp.x1 = x1;
            tmp.x2 = x2;
            tmp.y1 = y1;
            tmp.y2 = y2;
            tmp.liniajestczerwona = this.liniajestczerwona;
            obszargry.linie.add(tmp);

            x1 = x2;
            y1 = y2;

            obszargry.repaint();
            //jeżeli aktualna pozycja nie pozwala już na wykonanie ruchu, to zmieniamy gracza
            if (!wykorzystanepozycje.contains(pozycja) && !graniceplanszy.contains(pozycja)) {
                wykorzystanepozycje.add(pozycja);
                liniajestczerwona = !liniajestczerwona;
                obszargry.aktualnygraczjestczerwony = !obszargry.aktualnygraczjestczerwony;

            }
            if (bramka1.contains(pozycja)) { //jeśli znajdujemy się w bramce to kończymy grę
                KoniecGry(2);
            } else if (bramka2.contains(pozycja)) {
                KoniecGry(1);
            }
            if (obszargry.aktualnygraczjestczerwony == true) {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwapierwszegogracza);
            } else {
                setTitle("Aktualny gracz: " + gra.Pilkarzyki.nazwadrugiegogracza);
            }
            return true;
        } else {

            if (CzyZablokowany()) {

                KoniecGry(3);
            }
            return false;
        }
    }

    boolean CzyZablokowany() {

        //tworzymy tymczasowy przebieg gry, jak podczas sprawdzania ruchu
        PrzebiegGry przebiegtmp = new PrzebiegGry();

        przebiegtmp.poczatek = pozycja;

        // gora
        przebiegtmp.koniec = pozycja + 10;
        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 114 && pozycja != 116) {
            return false;
        }
        //lewo
        przebiegtmp.koniec = pozycja - 1;
        if (!przebieggry.contains(przebiegtmp) && !lewoplanszy.contains(pozycja) && !dolplanszy.contains(pozycja) && !goraplanszy.contains(pozycja) && pozycja != 114 && pozycja != 14) {
            return false;
        }
        //dol
        przebiegtmp.koniec = pozycja - 10;
        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 14 && pozycja != 16) {
            return false;
        }
        //prawo
        przebiegtmp.koniec = pozycja + 1;
        if (!przebieggry.contains(przebiegtmp) && !prawoplanszy.contains(pozycja) && !dolplanszy.contains(pozycja) && !goraplanszy.contains(pozycja) && pozycja != 16 && pozycja != 116) {
            return false;
        }
        //goraprawo
        przebiegtmp.koniec = pozycja + 11;
        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 116 && pozycja != 119) {
            return false;
        }

        //goralewo
        przebiegtmp.koniec = pozycja + 9;
        if (!przebieggry.contains(przebiegtmp) && !goraplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && pozycja != 111 && pozycja != 114) {
            return false;
        }

        //dollewo
        przebiegtmp.koniec = pozycja - 11;
        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !lewoplanszy.contains(pozycja) && pozycja != 11 && pozycja != 14) {
            return false;
        }
        //dolprawo
        przebiegtmp.koniec = pozycja - 9;
        if (!przebieggry.contains(przebiegtmp) && !dolplanszy.contains(pozycja) && !prawoplanszy.contains(pozycja) && pozycja != 16 && pozycja != 19) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rozgrywka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rozgrywka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rozgrywka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rozgrywka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rozgrywka().setVisible(true);

            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int x = e.getKeyCode();
        if (x == 97) {
            RuchDolLewo();
        } else if (x == 98) {
            RuchDol();
        } else if (x == 99) {
            RuchDolPrawo();
        } else if (x == 100) {
            RuchLewo();
        } else if (x == 102) {
            RuchPrawo();
        } else if (x == 103) {
            RuchGoraLewo();
        } else if (x == 104) {
            RuchGora();
        } else if (x == 105) {
            RuchGoraPrawo();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void start_stoper() {
        myTimer.scheduleAtFixedRate(task, 10, 100);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField czas_gracza1;
    private javax.swing.JTextField czas_gracza2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nazwa_gracza1;
    private javax.swing.JLabel nazwa_gracza2;
    private javax.swing.JButton przyciskZakonczRozgrywke;
    private javax.swing.JTextField test;
    private javax.swing.JLabel wynik_gracza1;
    private javax.swing.JLabel wynik_gracza2;
    // End of variables declaration//GEN-END:variables

   

}
