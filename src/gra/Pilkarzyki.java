package gra;

import gra.MenuGlowne;
import gra.Gracz;
import gra.ListaGraczy;
import gra.Rozgrywka;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pilkarzyki {
    public static MenuGlowne menuglowne; //obiekt okna menu glownego
    public static String nazwapierwszegogracza;
    public static String nazwadrugiegogracza;
    public static int wynikpierwszegogracza;
    public static int wynikdrugiegogracza;
    public static Rozgrywka rozgrywka;
    public static Thread cpu;
    public static ListaGraczy lista;
    public static Gracz[] gracze;
    
   
    public static void main(String[] args) {
        menuglowne = new MenuGlowne(); //tworzymy okno menu głównego        
        menuglowne.setVisible(true);
        
        //tablica przechowująca dane dwóch graczy
        gracze = new Gracz[2];
        
        //odczytanie listy graczy z pliku
        try {
            lista = new ListaGraczy();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pilkarzyki.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pilkarzyki.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
