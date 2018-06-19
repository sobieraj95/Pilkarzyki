package gra;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class ObszarGry extends JPanel {

    /*tablica z obiektami linii - potrzebujemy takiej, aby moc rysowac
    wszystkie linie za jednym razem*/
    public ArrayList<Linia> linie;

    Image img; //obrazek tła
    boolean aktualnygraczjestczerwony = true; //dzięki tej zmiennej wiemy, jakiego koloru kropke narysowac
    Font font;

    public ObszarGry() {
        linie = new ArrayList<Linia>();
        font = new Font("Amatic", Font.PLAIN, 40);

        try {
            img = ImageIO.read(new File("src/image/tlo.png")); //odczytaneie tła i zapisanie go do zmiennej
        } catch (IOException e) {
        }
    }

    @Override //główna funkcja rysująca grafikę
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //uzyskujemy dostep do klasy bazowej
        Graphics2D g2d = (Graphics2D) g; //obiekt do rysowania 2D
        g2d.drawImage(img, 0, 0, null); //rysujemy tło

        int szerokosc = 400;
        int wysokosc = 400;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(1));

        for (int i = 100; i <= szerokosc - 100; i += 25) {
            g2d.drawLine(i, 75, i, wysokosc - 75);
        }
        for (int j = 75; j <= wysokosc - 75; j += 25) {
            g2d.drawLine(100, j, szerokosc - 100, j);
        }

        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(100, 75, 175, 75);
        g2d.setColor(Color.RED);
        g2d.drawLine(175, 75, 175, 50);
        g2d.drawLine(175, 50, 225, 50);
        g2d.drawLine(225, 50, 225, 75);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(225, 75, 300, 75);
        g2d.drawLine(300, 75, 300, 325);
        g2d.drawLine(300, 325, 225, 325);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(225, 325, 225, 350);
        g2d.drawLine(225, 350, 175, 350);
        g2d.drawLine(175, 350, 175, 325);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(175, 325, 100, 325);
        g2d.drawLine(100, 325, 100, 75);

        g2d.setStroke(new BasicStroke(3)); //ustawiamy grubość linii
        g2d.setFont(font);
        int kropkax = 200; //musimy miec zainicjalizowane wspolrzedne kropek
        int kropkay = 200;

        //pętlą foreach przechodzimy po kolekcji linii, aby narysować wszystkie naraz
        for (Linia tmp : linie) {
            if (tmp.liniajestczerwona) { //musimy narysowac linię w dobrym kolorze, więc ustawiamy kolor
                g2d.setColor(Color.red);
            } else {
                g2d.setColor(Color.blue);

            }
            g2d.drawLine(tmp.x1, tmp.y1, tmp.x2, tmp.y2); //w końcu rysujemy pojedynczą linię w pętli
            kropkax = tmp.x2; //zapisanie końcówki ostatniej linii jako kropki
            kropkay = tmp.y2;
        }
        if (aktualnygraczjestczerwony) { //ustawiamy kolor kropki
            g2d.setColor(Color.red);
        } else {
            g2d.setColor(Color.blue);
        }

        g2d.drawOval(kropkax - 2, kropkay - 2, 4, 4); //rysujemy kropkę, już po zakończeniu rysowania wszystkich linii                
    }
}
