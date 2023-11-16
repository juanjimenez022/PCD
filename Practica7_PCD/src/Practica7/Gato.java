/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.monitor.Monitor;

/**
 *
 * @author jujis
 */
public class Gato implements Runnable {

    private Comedero comedero;
    Random rn = new Random(System.currentTimeMillis());

    public Gato(Comedero comedero) {
        this.comedero = comedero;
    }
    
    @Override
    public void run() {

        try {
            
            //Gato entra en comedero
            
            System.out.println("El Gato: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta entrar a comedero");
            comedero.EntraGato("G" + Thread.currentThread().getId());
            //simulacion tiempo comer
            
            System.out.println("El Gato: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " Come");
            Thread.sleep(rn.nextInt(1, 4) * 1000);//1000
            //Gato sale comedero
            
            System.out.println("El Gato: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta Salir del comedero");
            comedero.SaleGato();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
