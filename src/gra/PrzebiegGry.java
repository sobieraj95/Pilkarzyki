package gra;

/**
 *klasa, która przechowuje pojedynczy ruch gracza
 *przykladowo z punktu 2 jako początek do punktu 10 jako koniec
 */


public class PrzebiegGry{
    int poczatek;
    int koniec;
    
    
    
    //tworząc własną metodę equals, środowisko doradza także stworzenie metody hashcode
    @Override
    public int hashCode() {
        int hash = 10;
        hash = 37 * hash + this.poczatek;
        hash = 37 * hash + this.koniec;
        return hash;
    }

    
    /*potrzebujemy porównywać dwa ruchy, aby nie można było wykonać drugiego takiego samego
    jednakże należy pamiętać o tym, że przykładowo ruch z 2 do 10 jest równoważny z 10 do 2
    wobec czego musieliśmy napisać osobną metodę equals */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrzebiegGry other = (PrzebiegGry) obj;
        if (other.poczatek==this.poczatek && other.koniec==this.koniec){ //jeśli początek i koniec są takie same, to ruch jest ten sam
            return true;
        }
        if (other.poczatek!=this.poczatek && other.koniec!=this.koniec){ 
            /*jesli początek i koniec są różne to jeszcze jest możliwość, że poczatek jest równy końcowi a koniec początkowi
            co oznacza, że wykonany ruch jest równoważny
            */
            if (other.poczatek==this.koniec && this.poczatek==other.koniec)
                return true;
        }
        
       
        return false; //jeśli żaden warunek nie został spełniony
    }
    
    
}
