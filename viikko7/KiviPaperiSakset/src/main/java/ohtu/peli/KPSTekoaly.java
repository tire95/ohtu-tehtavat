package ohtu.peli;

import ohtu.tekoaly.Tekoaly;
import ohtu.tekoaly.TekoalyParannettu;
import ohtu.tekoaly.TekoalyYksinkertainen;

public class KPSTekoaly extends KPSPeli {
    private Tekoaly tekoaly;

    public KPSTekoaly(int i) {
        if (i == 0) {
            this.tekoaly = new TekoalyYksinkertainen();
        } else {
            this.tekoaly = new TekoalyParannettu(20);
        }
    }

    @Override
    protected String getTokanSiirto() {
        String siirto = this.tekoaly.annaSiirto();
        io.print(siirto);
        return siirto;
    }
}