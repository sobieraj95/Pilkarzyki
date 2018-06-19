package gra;

import gra.AlgorytmKomputera;
import gra.Rozgrywka;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class MenuGlowne extends javax.swing.JFrame {
    DefaultTableModel model;
    public static Rozgrywka rozgrywka;
    public MenuGlowne() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_dwoch_graczy = new javax.swing.JPanel();
        pole_gracz1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pole_gracz2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rozpocznij_grę_dwojka = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Panel_jednego_gracza = new javax.swing.JPanel();
        pole_gracz3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rozpocznij_grę_dwojka1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel_statystyki = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        panel_przyciski = new javax.swing.JPanel();
        przyciskGrajZDrugimGraczem = new javax.swing.JButton();
        przyciskGrajZKomputerem = new javax.swing.JButton();
        przyciskWyswietlStatystykiGraczy = new javax.swing.JButton();
        Wyjscie = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Piłkarzyki Menu Główne");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 630));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        Panel_dwoch_graczy.setVisible(false);
        Panel_dwoch_graczy.setPreferredSize(new java.awt.Dimension(500, 500));
        Panel_dwoch_graczy.setLayout(null);

        pole_gracz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pole_gracz1ActionPerformed(evt);
            }
        });
        Panel_dwoch_graczy.add(pole_gracz1);
        pole_gracz1.setBounds(20, 30, 160, 31);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Imię pierwszego gracza:");
        Panel_dwoch_graczy.add(jLabel3);
        jLabel3.setBounds(20, 10, 160, 21);
        Panel_dwoch_graczy.add(pole_gracz2);
        pole_gracz2.setBounds(20, 90, 160, 31);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Imię drugiego gracza:");
        Panel_dwoch_graczy.add(jLabel4);
        jLabel4.setBounds(20, 70, 160, 19);

        rozpocznij_grę_dwojka.setText("Rozpocznij grę");
        rozpocznij_grę_dwojka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rozpocznij_grę_dwojkaActionPerformed(evt);
            }
        });
        Panel_dwoch_graczy.add(rozpocznij_grę_dwojka);
        rozpocznij_grę_dwojka.setBounds(20, 130, 160, 23);

        jButton2.setText("Cofnij");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Panel_dwoch_graczy.add(jButton2);
        jButton2.setBounds(50, 160, 90, 23);

        getContentPane().add(Panel_dwoch_graczy);
        Panel_dwoch_graczy.setBounds(200, 380, 200, 200);

        Panel_jednego_gracza.setVisible(false);
        Panel_jednego_gracza.setLayout(null);

        pole_gracz3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pole_gracz3ActionPerformed(evt);
            }
        });
        Panel_jednego_gracza.add(pole_gracz3);
        pole_gracz3.setBounds(20, 30, 160, 31);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Podaj swoje imie:");
        Panel_jednego_gracza.add(jLabel5);
        jLabel5.setBounds(20, 10, 160, 21);

        rozpocznij_grę_dwojka1.setText("Rozpocznij grę");
        rozpocznij_grę_dwojka1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rozpocznij_grę_dwojka1ActionPerformed(evt);
            }
        });
        Panel_jednego_gracza.add(rozpocznij_grę_dwojka1);
        rozpocznij_grę_dwojka1.setBounds(20, 70, 160, 23);

        jButton3.setText("Cofnij");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Panel_jednego_gracza.add(jButton3);
        jButton3.setBounds(50, 100, 90, 23);

        getContentPane().add(Panel_jednego_gracza);
        Panel_jednego_gracza.setBounds(200, 380, 200, 150);

        panel_statystyki.setVisible(false);
        panel_statystyki.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gracz", "Bramki strzelone", "Bramki stracone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        panel_statystyki.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 290, 130);

        jButton1.setText("Cofnij");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_statystyki.add(jButton1);
        jButton1.setBounds(100, 150, 100, 23);

        getContentPane().add(panel_statystyki);
        panel_statystyki.setBounds(140, 380, 310, 180);

        panel_przyciski.setOpaque(false);
        panel_przyciski.setLayout(null);

        przyciskGrajZDrugimGraczem.setBackground(java.awt.Color.lightGray);
        przyciskGrajZDrugimGraczem.setFont(new java.awt.Font("Amatic", 0, 18)); // NOI18N
        przyciskGrajZDrugimGraczem.setText("Graj z drugim graczem");
        przyciskGrajZDrugimGraczem.setActionCommand("");
        przyciskGrajZDrugimGraczem.setBorder(null);
        przyciskGrajZDrugimGraczem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przyciskGrajZDrugimGraczemActionPerformed(evt);
            }
        });
        panel_przyciski.add(przyciskGrajZDrugimGraczem);
        przyciskGrajZDrugimGraczem.setBounds(10, 10, 260, 43);

        przyciskGrajZKomputerem.setBackground(java.awt.Color.lightGray);
        przyciskGrajZKomputerem.setFont(new java.awt.Font("Amatic", 0, 18)); // NOI18N
        przyciskGrajZKomputerem.setText("Graj z komputerem");
        przyciskGrajZKomputerem.setActionCommand("");
        przyciskGrajZKomputerem.setBorder(null);
        przyciskGrajZKomputerem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przyciskGrajZKomputeremActionPerformed(evt);
            }
        });
        panel_przyciski.add(przyciskGrajZKomputerem);
        przyciskGrajZKomputerem.setBounds(10, 60, 260, 43);

        przyciskWyswietlStatystykiGraczy.setBackground(java.awt.Color.lightGray);
        przyciskWyswietlStatystykiGraczy.setFont(new java.awt.Font("Amatic", 0, 18)); // NOI18N
        przyciskWyswietlStatystykiGraczy.setText("Wyświetl statystyki ");
        przyciskWyswietlStatystykiGraczy.setActionCommand("");
        przyciskWyswietlStatystykiGraczy.setBorder(null);
        przyciskWyswietlStatystykiGraczy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przyciskWyswietlStatystykiGraczyActionPerformed(evt);
            }
        });
        panel_przyciski.add(przyciskWyswietlStatystykiGraczy);
        przyciskWyswietlStatystykiGraczy.setBounds(10, 110, 260, 43);

        Wyjscie.setBackground(java.awt.Color.lightGray);
        Wyjscie.setFont(new java.awt.Font("Amatic", 0, 18)); // NOI18N
        Wyjscie.setText("Wyjście");
        Wyjscie.setActionCommand("");
        Wyjscie.setBorder(null);
        Wyjscie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WyjscieActionPerformed(evt);
            }
        });
        panel_przyciski.add(Wyjscie);
        Wyjscie.setBounds(50, 160, 170, 40);

        getContentPane().add(panel_przyciski);
        panel_przyciski.setBounds(160, 380, 280, 210);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu_pilkarz.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 0, 400, 380);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tlo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void przyciskGrajZDrugimGraczemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przyciskGrajZDrugimGraczemActionPerformed
        Panel_dwoch_graczy.setVisible(true);
        Panel_jednego_gracza.setVisible(false);
        panel_statystyki.setVisible(false);
        panel_przyciski.setVisible(false);
    }//GEN-LAST:event_przyciskGrajZDrugimGraczemActionPerformed

    private void WyjscieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WyjscieActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_WyjscieActionPerformed

    private void przyciskGrajZKomputeremActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przyciskGrajZKomputeremActionPerformed
    
       
        Panel_jednego_gracza.setVisible(true);
        Panel_dwoch_graczy.setVisible(false);
        panel_statystyki.setVisible(false);
        panel_przyciski.setVisible(false);
        
    }//GEN-LAST:event_przyciskGrajZKomputeremActionPerformed

    private void przyciskWyswietlStatystykiGraczyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przyciskWyswietlStatystykiGraczyActionPerformed
        Panel_dwoch_graczy.setVisible(false);
        Panel_jednego_gracza.setVisible(false);
        panel_przyciski.setVisible(false);
        
        model = (DefaultTableModel) jTable1.getModel();
        
        String[] rowData = new String[3];
        for (String tmp : gra.Pilkarzyki.lista.mapa.keySet()) {
            rowData[0] = tmp;
            rowData[1] = Integer.toString(gra.Pilkarzyki.lista.mapa.get(tmp).getLiczbaStrzelonychBramek());
            rowData[2] = Integer.toString(gra.Pilkarzyki.lista.mapa.get(tmp).getLiczbaStraconychBramek());
            model.addRow(rowData);
        }

        panel_statystyki.setVisible(true);
    }//GEN-LAST:event_przyciskWyswietlStatystykiGraczyActionPerformed

    private void rozpocznij_grę_dwojkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rozpocznij_grę_dwojkaActionPerformed
        
        gra.Pilkarzyki.nazwapierwszegogracza = pole_gracz1.getText();
        gra.Pilkarzyki.nazwadrugiegogracza = pole_gracz2.getText();
        
        //nazwa gracza nie może być pusta oraz nie może zawierać "Komputer" - ponieważ jest zarezerwowana
        if (pole_gracz1.getText().contains("Komputer") || pole_gracz1.getText().equals("") || pole_gracz2.getText().contains("Komputer") || pole_gracz2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nazwa nie może być pusta ani zawierać nazwy \"Komputer\"!");
        } else {
            //sprawy związane z bazą danych
            gra.Pilkarzyki.gracze[0] = gra.Pilkarzyki.lista.PobierzGraczaZBazy(pole_gracz1.getText()); //pobieramy z bazy gracza o takiej nazwie i wrzucamy jednocześnie do obiektu gracza
            gra.Pilkarzyki.gracze[1] = gra.Pilkarzyki.lista.PobierzGraczaZBazy(pole_gracz2.getText()); //pobieramy z bazy gracza o takiej nazwie i wrzucamy jednocześnie do obiektu gracza       

            gra.Pilkarzyki.rozgrywka = new Rozgrywka();
            gra.Pilkarzyki.rozgrywka.setVisible(true);
        }
        dispose();

    }//GEN-LAST:event_rozpocznij_grę_dwojkaActionPerformed

    private void pole_gracz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pole_gracz1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pole_gracz1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Panel_dwoch_graczy.setVisible(false);        
        panel_przyciski.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pole_gracz3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pole_gracz3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pole_gracz3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Panel_jednego_gracza.setVisible(false);
        panel_przyciski.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rozpocznij_grę_dwojka1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rozpocznij_grę_dwojka1ActionPerformed
        // TODO add your handling code here:

        gra.Pilkarzyki.nazwapierwszegogracza = pole_gracz3.getText();
        gra.Pilkarzyki.nazwadrugiegogracza = "Komputer";

        //nazwa gracza nie może być pusta oraz nie może zawierać "Komputer" - ponieważ jest zarezerwowana
        if (pole_gracz3.getText().contains("Komputer") || pole_gracz3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nazwa nie może być pusta ani zawierać nazwy \"Komputer\"!");
        } else {
            //sprawy związane z bazą danych
            gra.Pilkarzyki.gracze[0] = gra.Pilkarzyki.lista.PobierzGraczaZBazy(pole_gracz3.getText()); //pobieramy z bazy gracza o takiej nazwie i wrzucamy jednocześnie do obiektu gracza
            gra.Pilkarzyki.gracze[1] = gra.Pilkarzyki.lista.PobierzGraczaZBazy("Komputer"); //pobieramy z bazy gracza o takiej nazwie i wrzucamy jednocześnie do obiektu gracza       

            gra.Pilkarzyki.rozgrywka = new Rozgrywka();
            gra.Pilkarzyki.rozgrywka.setVisible(true);
            gra.Pilkarzyki.cpu = new Thread(new AlgorytmKomputera());
            gra.Pilkarzyki.cpu.start();

        }
        dispose();
    }//GEN-LAST:event_rozpocznij_grę_dwojka1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ilosc = model.getRowCount();
        for (int i = 0; i < ilosc; i++) {
            model.removeRow(0);
        }
        panel_statystyki.setVisible(false);
        panel_przyciski.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGlowne().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_dwoch_graczy;
    private javax.swing.JPanel Panel_jednego_gracza;
    private javax.swing.JButton Wyjscie;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_przyciski;
    private javax.swing.JPanel panel_statystyki;
    private javax.swing.JTextField pole_gracz1;
    private javax.swing.JTextField pole_gracz2;
    private javax.swing.JTextField pole_gracz3;
    private javax.swing.JButton przyciskGrajZDrugimGraczem;
    public javax.swing.JButton przyciskGrajZKomputerem;
    private javax.swing.JButton przyciskWyswietlStatystykiGraczy;
    private javax.swing.JButton rozpocznij_grę_dwojka;
    private javax.swing.JButton rozpocznij_grę_dwojka1;
    // End of variables declaration//GEN-END:variables
}
