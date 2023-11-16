/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class Perro extends Thread {

    private Comedero comedero;
    Random rn = new Random(System.currentTimeMillis());

    public Perro(Comedero comedero) {
        this.comedero = comedero;
    }
    
    @Override
    public void run() {

        try {
            
            //Gato entra en comedero
            
            System.out.println("El Perro: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta entrar a comedero");
            comedero.EntraPerro("P" + Thread.currentThread().getId());
            //simulacion tiempo comer
            
            System.out.println("El Perro: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " Come");
            Thread.sleep(rn.nextInt(1, 4) * 1000);//1000
            //Gato sale comedero
            
            System.out.println("El Perro: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta Salir del comedero");
            comedero.SalePerro();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
