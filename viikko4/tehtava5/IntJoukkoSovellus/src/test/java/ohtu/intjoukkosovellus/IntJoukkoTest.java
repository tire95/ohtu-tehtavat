package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaaJonoon(10);
        joukko.lisaaJonoon(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaaJonoon(4);
        assertEquals(3, joukko.getAlkioidenLkm());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaaJonoon(10);
        joukko.lisaaJonoon(3);
        assertEquals(2, joukko.getAlkioidenLkm());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluuJonoon(10));
        assertFalse(joukko.kuuluuJonoon(5));
        assertTrue(joukko.kuuluuJonoon(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poistaJonosta(3);
        assertFalse(joukko.kuuluuJonoon(3));
        assertEquals(1, joukko.getAlkioidenLkm());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaaJonoon(55);
        joukko.poistaJonosta(10);
        joukko.lisaaJonoon(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaaJonoon(luku);
        }
        assertEquals(14, joukko.getAlkioidenLkm());
        assertTrue(joukko.kuuluuJonoon(11));
        joukko.poistaJonosta(11);
        assertFalse(joukko.kuuluuJonoon(11));
        assertEquals(13, joukko.getAlkioidenLkm());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntJoukko();
        joukko.lisaaJonoon(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }     
}
