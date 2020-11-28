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
public class Erotus extends Komento{

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.miinus(arvo);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");   
        this.nollaa.disableProperty().set(false);
    }

    @Override
    public void peru() {
        this.sovellus.plus(arvo);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");
        this.undo.disableProperty().set(true);
    }
    
}
