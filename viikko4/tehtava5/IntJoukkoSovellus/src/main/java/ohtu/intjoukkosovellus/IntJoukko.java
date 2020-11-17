
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // n채in paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on t채m채n verran vanhaa suurempi.
    private int[] lukuJono;      // Joukon luvut s채ilytet채채n taulukon alkup채채ss채. 
    private int alkioidenLkm;    // Tyhj채ss채 joukossa alkioiden_m채채r채 on nolla. 

    public IntJoukko() {
        lukuJono = new int[OLETUSKAPASITEETTI];
        alustaIntJoukko(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaIntJoukko(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti v채채rin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko v狎rin");//heitin vaan jotain :D
        }
        alustaIntJoukko(kapasiteetti, kasvatuskoko);
    }
    
    private void alustaIntJoukko(int kapasiteetti, int kasvatusKoko) {
        lukuJono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatusKoko = kasvatusKoko;
    }

    public boolean lisaaJonoon(int luku) {
        if (!kuuluuJonoon(luku)) {
            lukuJono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukuJono.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJonoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaJonosta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJono[i]) {
                int luvunIndeksi = i;
                lukuJono[luvunIndeksi] = 0;
                tiivistaTaulukkoa(luvunIndeksi);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kasvataTaulukkoa() {
        int[] uusiTaulukko = new int[lukuJono.length + kasvatusKoko];
        for (int i = 0; i < lukuJono.length; i++) {
            uusiTaulukko[i] = lukuJono[i];
        }
        lukuJono = uusiTaulukko;

    }
    
    private void tiivistaTaulukkoa(int luvunIndeksi) {
         for (int j = luvunIndeksi; j < alkioidenLkm - 1; j++) {
             int apu = lukuJono[j];
                lukuJono[j] = lukuJono[j + 1];
                lukuJono[j + 1] = apu;
            }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukuJono[0] + "}";
        } else {
            String taulukkoStringina = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                taulukkoStringina += lukuJono[i];
                taulukkoStringina += ", ";
            }
            taulukkoStringina += lukuJono[alkioidenLkm - 1];
            taulukkoStringina += "}";
            return taulukkoStringina;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuJono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.lisaaJonoon(bTaulu[i]);
        }
        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int indeksi = 0;
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluuJonoon(aTaulu[i])) {
             leikkausJoukko.lisaaJonoon(bTaulu[indeksi]);
             indeksi++;
            }
        }
        return leikkausJoukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.poistaJonosta(bTaulu[i]);
        }
 
        return a;
    }
        
}
