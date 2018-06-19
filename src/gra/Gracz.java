/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;

/**
 *
 * @author Grzegorz
 */
public class Gracz implements java.io.Serializable {
    int liczbaStrzelonychBramek;
    int liczbaStraconychBramek;
    String nazwaGracza;

    public Gracz(String nazwaGracza) {
        this.nazwaGracza = nazwaGracza;
        liczbaStraconychBramek = 0;
        liczbaStrzelonychBramek = 0;
    }

    public int getLiczbaStrzelonychBramek() {
        return liczbaStrzelonychBramek;
    }

    public int getLiczbaStraconychBramek() {
        return liczbaStraconychBramek;
    }

    public String getNazwaGracza() {
        return nazwaGracza;
    }
       
    
    public void ZwiekszZdobyteBramki(int liczba){
        liczbaStrzelonychBramek+=liczba;
    }
    
    public void ZwiekszStraconeBramki(int liczba){
        liczbaStraconychBramek+=liczba;
    }
    
}
