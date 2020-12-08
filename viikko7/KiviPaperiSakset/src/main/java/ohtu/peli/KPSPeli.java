/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.peli;

import ohtu.kivipaperisakset.IO;
import ohtu.kivipaperisakset.Tuomari;

/**
 *
 * @author timot
 */
public abstract class KPSPeli {
    
    protected IO io;
    protected String ekanSiirto;
    protected String tokanSiirto;
    
    public KPSPeli() {
        this.io = new IO();
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        getSiirrot();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");
            
            getSiirrot();
        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }
    
    protected abstract String getTokanSiirto();

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    private void getSiirrot() {
        io.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = io.nextLine();
        io.print("Toisen pelaajan siirto: ");
        tokanSiirto = getTokanSiirto();
    }
    
}
