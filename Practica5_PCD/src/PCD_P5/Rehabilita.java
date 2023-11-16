/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCD_P5;

import java.util.Random;

/**
 *
 * @author jujis
 */
public class Rehabilita implements Runnable {

    private Centro centro;
    private Random rn = new Random();
    String cliente = "R";

    public Rehabilita(Centro centro) {
        this.centro = centro;
    }

    @Override
    public void run() {
        try {
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta entrar a rehabilitacion");
            centro.EntraRehabilitacion(cliente+Thread.currentThread().getId());
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " esta haciendo rehabilitación");
            // Simular el tiempo de rehabilitación (entre 2 y 4 segundos)
            Thread.sleep(rn.nextInt(3000) + 2000);
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " ha terminado la rehabilitacion");
            centro.SaleRehabilitacion(cliente+Thread.currentThread().getId());
            //vamos pal vestuario
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " Espera a vestuario");
            Thread.sleep(2000);
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " Sale del vestuario");
            centro.Termina();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
