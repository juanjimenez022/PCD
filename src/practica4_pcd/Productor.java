/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_pcd;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class Productor extends Thread {

    PilaLenta lapila;
    Random rn;

    public Productor(PilaLenta pila) {
        this.lapila = pila;

    }

    public void producir() {
        run();
    }

    @Override
    public void run() {
        rn = new Random(System.currentTimeMillis());
        try {
            for (int i = 0; i < 15; i++) {
                sleep(rn.nextInt(1000, 3000));
                long num=i+getId()*10;
                lapila.Apila(num);
                System.out.println("Hilo "+getId()+" Apila "+num);
                
            }

        } catch (Exception ex) {
            System.out.println("Se ha fallado al intentar llamar a apila en el metodo producir");
        }
    }
}
