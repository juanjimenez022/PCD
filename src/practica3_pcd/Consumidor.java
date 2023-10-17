/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3_pcd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class Consumidor implements Runnable {

    PilaLenta lapila;
    
    public Consumidor(PilaLenta mipila) {
        this.lapila=mipila;
    }

    

    public void consumir() {
        run();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                lapila.Desapila();
            } catch (Exception ex) {
                System.out.println("En el metodo run no ha funcionado la llamada a Desapila");
            }
        }
        
    }

}
