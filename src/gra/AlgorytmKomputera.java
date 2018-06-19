package gra;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgorytmKomputera implements Runnable{
    
     public static boolean isRunning;
    public void run(){
       
         isRunning = true;
         while(isRunning){
             try {
                    Thread.sleep(10); //jak tu nie dam sleepa to sie psuje, nie wiem czemu
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgorytmKomputera.class.getName()).log(Level.SEVERE, null, ex);
                }
            while(!gra.Pilkarzyki.rozgrywka.liniajestczerwona ){ //komputer jest niebieskim graczem - sprawdzamy czy ma prawo ruchu
               try {
                    Thread.sleep(250); //troche opoznienia aby bylo widac animacje ruchu
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgorytmKomputera.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*
                Poruszamy się na zasadzie, że gdy jest możliwość ruchu to idziemy w danym kierunku, jesli nie ma to idziemy w innym
                I tak robimy aż skończą się nam ruchy.
                Bramką komputera jest bramka dolna, wobec czego komputer idzie do góry aby strzelić w górną bramkę.
                Wobec tego algorytm idzie najpierw w górę, jeśli nie ma takiej możliwości to kieruje się do góry w lewo lub prawo(po skosie) itd.
                Typowa kolejność ruchów:
                -góra
                -góra lewo
                -góra prawo
                -lewo
                -prawo
                -dol
                -dollewo
                -dolprawo
                
               Przed każdym ruchem należy sprawdzać, czy ruch należy do nas - dzięki czemu zapobiegamy 
               wykonywaniu ruchów przez komputer gdy ruch powinien być nasz
                */
                  //specjalne przypadki
                //przypadek przed bramką - chcemy, żeby na początku komputer odbił piłke od słupka i skierował do bramki
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == 45) {
                    if (gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolPrawo()) {
                        break;
                    }
                }

                //przypadek przed bramką po prawej - chcemy by poszedł od razu w lewo do góry po skosie (odbił od prawego słupka)
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == 47) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                        break;
                    }
                }

                //przypadek przed bramką po lewej - chcemy by poszedł od razu w prawo do góry po skosie (odbił od lewego słupka)
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == 43) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                        break;
                    }
                }

                //blisko lewego górnego kantu nie wykonamy kierunku lewo - góra bo przegramy
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == 42) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolPrawo()) {
                        break;
                    }

                }

                //blisko prawego górnego kantu nie wykonamy kierunku prawo - góra bo przegramy
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == 48) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolPrawo()) {
                        break;
                    }

                }

                //blisko lewego dolnego kantu nie wykonamy kierunku lewo - dół bo przegramy 
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == -38) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolPrawo()) {
                        break;
                    }

                }

                //blisko prawego dolnego kantu nie wykonamy kierunku prawo - dół bo przegramy 
                if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.pozycja == -32) {
                    if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                        break;
                    } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolLewo()) {
                        break;
                    }

                } //w pozostałych przypadkach poruszamy się w ten sposób
                else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGora()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraLewo()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchGoraPrawo()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchLewo()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchPrawo()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDol()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolLewo()) {
                    break;
                } else if (!gra.Pilkarzyki.rozgrywka.liniajestczerwona && gra.Pilkarzyki.rozgrywka.RuchDolPrawo()) {
                    break;
                }

            }
        }
    }
    
}
