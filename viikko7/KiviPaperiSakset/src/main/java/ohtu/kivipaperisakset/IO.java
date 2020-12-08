/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author timot
 */
public class IO {
    private Scanner lukija;
    
    public IO() {
        lukija = new Scanner(System.in);
    }
    
    public String nextLine() {
        return lukija.nextLine();
    }
    
    public void print(String m) {
        System.out.println(m);
    }
    
}
