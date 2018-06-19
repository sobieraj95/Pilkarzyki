package gra;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaGraczy implements java.io.Serializable {
 
    public HashMap<String, Gracz> mapa; //hashmapa zawierająca łańcuch loginu jako klucz i obiekt gracza jako dana mu odpowiadająca
    
    public ListaGraczy() throws ClassNotFoundException, FileNotFoundException, IOException{
        
        ObjectInputStream plikin = null; //tworzenie strumienia do pliku wejsciowego
        try {
            mapa = new HashMap<>(); //tworzenie nowej hashmapy
            //odczytywanie obiektu bazy z pliku
            
            FileInputStream plikwejsciowy = new FileInputStream("baza.ser");
            plikin = new ObjectInputStream(plikwejsciowy);
            mapa = (HashMap<String, Gracz>) plikin.readObject();
            plikin.close();
            plikwejsciowy.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
    }    
    
    
    //zapisanie bazy do pliku przed wyjsciem z serwera
    public void ZapiszListe() throws IOException{
        FileOutputStream plikwyjsciowy = null; //tworzenie strumieniea do pliku wyjsciowego
        try {
            //tworzenie nowego pliku
            plikwyjsciowy = new FileOutputStream("baza.ser");
            ObjectOutputStream plikout = new ObjectOutputStream(plikwyjsciowy);
            plikout.writeObject(mapa); //zapis hashmapy z obiektami gracza do pliku
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaGraczy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                plikwyjsciowy.close();
            } catch (IOException ex) {
                Logger.getLogger(ListaGraczy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public Gracz PobierzGraczaZBazy(String imie){
        if (mapa.containsKey(imie)){ //jeśli mamy już takiego gracza to nie dodajemy nowego tylko zwracamy istniejącego
            return mapa.get(imie);
        }
        else{
            Gracz gracz = new Gracz(imie); //jeśli nie ma takiego gracza, to tworzmymy jego obiekt i od razu wrzucamy go w listę
            mapa.put(imie, gracz);
            return mapa.get(imie);
        }
         
    }

    public void ZaktualizujWynik(String imie, Gracz gracz){
        mapa.put(imie, gracz); //funkcja zastępuje wprowadzone dane pod tym samym kluczem
    }
    
}

