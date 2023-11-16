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
public class Masaje extends Thread {

    private Centro centro;
    private Random random = new Random();
    String cliente = "M";

    public Masaje(Centro centro) {
        this.centro = centro;
    }

    @Override
    public void run() {
        try {
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " intenta entrar a masaje");
            centro.EntraMasaje(cliente+threadId());
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " esta recibiendo masaje");
            // Simular el tiempo de masaje (entre 2 y 4 segundos)
            Thread.sleep(random.nextInt(3000) + 2000);
            System.out.println("El hilo: " + Thread.currentThread().getName() + " con Id " + Thread.currentThread().getId() + " ha terminado el masaje");
            centro.SaleMasaje(cliente+threadId());
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
