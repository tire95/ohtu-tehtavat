/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import ohtu.peli.KPSPelaajaVsPelaaja;
import ohtu.peli.KPSPeli;
import ohtu.peli.KPSTekoaly;
import java.util.HashMap;

/**
 *
 * @author timot
 */
public class Pelitehdas {
    private HashMap<String, KPSPeli> pelit;
    
    public Pelitehdas() {
        pelit = new HashMap<>();
        pelit.put("a", new KPSPelaajaVsPelaaja());
        pelit.put("b", new KPSTekoaly(0));
        pelit.put("c", new KPSTekoaly(20));
    }
    
    public KPSPeli hae(String pelityyli) {
        return pelit.get(pelityyli);
    }
    
}
