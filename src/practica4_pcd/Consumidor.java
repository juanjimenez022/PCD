/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_pcd;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class Consumidor implements Runnable {

    PilaLenta lapila;
    Random rn;

    public Consumidor(PilaLenta mipila) {
        this.lapila = mipila;
    }

    public void consumir() {
        run();
    }

    @Override
    public void run() {
        rn = new Random(System.currentTimeMillis());

        for (int i = 0; i < 15; i++) {
            try {
                sleep(rn.nextInt(1000, 3000));
                
                System.out.println("Consumidor desapila "+lapila.Desapila());
            } catch (Exception ex) {
                System.out.println("En el metodo run no ha funcionado la llamada a Desapila");
            }
        }

    }

}
