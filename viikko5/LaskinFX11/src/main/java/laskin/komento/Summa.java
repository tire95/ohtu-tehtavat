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
public class Summa extends Komento{

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }


    @Override
    public void suorita() {
        this.arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.plus(arvo);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");
        this.nollaa.disableProperty().set(false);
        this.undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        this.sovellus.miinus(arvo);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syotekentta.setText("");
        this.undo.disableProperty().set(true);
    }
    
}
