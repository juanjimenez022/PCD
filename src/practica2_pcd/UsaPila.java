/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2_pcd;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class UsaPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        PilaLenta mipila = new PilaLenta(20);
        Consumidor C1 = new Consumidor(mipila);

        Productor h1 = new Productor(mipila);
        Productor h2 = new Productor(mipila);

        Thread h3 = new Thread(C1);
        Thread h4 =new Thread(C1);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h1.join();
        h2.join();
        h3.join();
        h4.join();

        mipila.GetNum();

    }

}
