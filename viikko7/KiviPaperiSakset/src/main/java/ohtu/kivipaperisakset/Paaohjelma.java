package ohtu.kivipaperisakset;

import java.util.Arrays;
import java.util.List;



public class Paaohjelma {

    static IO io = new IO();
    static Pelitehdas tehdas = new Pelitehdas();
    static List<String> vastaukset = Arrays.asList(new String[] {"a", "b", "c"});
    
    public static void main(String[] args) {

        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();
            if (vastaukset.contains(vastaus)) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                tehdas.hae(vastaus).pelaa();
            } else {
                break;
            }

        }

    }
}
