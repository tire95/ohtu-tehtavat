package ohtu.peli;

import ohtu.peli.KPSPeli;


public class KPSPelaajaVsPelaaja extends KPSPeli {


    @Override
    protected String getTokanSiirto() {
        return io.nextLine();
    }
    
    
}