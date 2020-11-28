/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author timot
 */
public class Nollaa extends Komento{

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = this.sovellus.tulos();
        this.sovellus.nollaa();
        this.tuloskentta.setText("0");
        this.syotekentta.setText("");  
        this.nollaa.disableProperty().set(true);
        this.undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        this.sovellus.plus(arvo);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");
        this.undo.disableProperty().set(true);
    }
    
}
