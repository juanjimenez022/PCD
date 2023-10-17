/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2_pcd;

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

    public void producir(){
        run();
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                rn = new Random(System.currentTimeMillis());
                lapila.Apila(rn.nextInt(500));
            }
            
        } catch (Exception ex) {
            System.out.println("Se ha fallado al intentar llamar a apila en el metodo producir");
        }
    }
}
