/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1_pcd;

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
    public static void main(String[] args) {
        // TODO code application logic here

        Pila mipila = new Pila(5);
        Random rn;
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            try {
                rn = new Random(System.currentTimeMillis());
                mipila.Apila(rn.nextInt(500));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        mipila.GetNum();
        try {
            System.out.println("\n");
            mipila.Primero();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            System.out.println("\n");
            mipila.Desapila();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
