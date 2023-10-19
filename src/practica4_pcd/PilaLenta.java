/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_pcd;

import java.awt.Canvas;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jujis
 */
public class PilaLenta implements iPila {

    int cima;
    int capacidad = 0;
    int numelementos = 0;
    Object datos[];
    CanvasPila CP;

    public PilaLenta(int capacidad, CanvasPila CP) {
        System.out.println("Inicializo la pila en el contructor");
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        this.CP = CP;
        cima = 0;
    }

    @Override
    public int GetNum() {

        System.out.println("Obtengo el numero de elementos de la pila: " + numelementos);
        return numelementos;
    }

    @Override
    public synchronized void Apila(Object elemento) throws Exception {

        int contadordeintentos = 0;
        while (pilallena() && contadordeintentos < 3) {
            wait();
            contadordeintentos++;
        }
        if (!pilallena()) {

            datos[cima] = elemento;
            numelementos++;
            cima++;
            CP.representa(cima, datos);
            //System.out.println("Apilo el elemento numero " + numelementos + " que contendra a " + elemento);

            notifyAll();
        } else {
            CP.avisa("La pila esta llena");
            if (contadordeintentos > 2) {
                throw new Exception("Han pasado 3 intentos... me retiro");

            }
        }

    }

    @Override
    public synchronized Object Desapila() throws Exception {

        int contadordeintentos = 0;

        while (pilavacia() && contadordeintentos < 3) {
            wait();
            contadordeintentos++;
        }
        if (!pilavacia()) {

            cima--;
            //System.out.println("Obtengo el elemento " + numelementos + " al Desapilar " + datos[cima]);
            numelementos--;
            CP.representa(cima, datos);
            Thread.sleep(250);
            notifyAll();
            return datos[cima];
        } else {

            CP.avisa("La pila esta vacia");
            if (contadordeintentos > 2) {
                throw new Exception("Han pasado 3 intentos... me retiro");

            }
        }

        return datos[cima];
    }

    @Override
    public Object Primero() throws Exception {

        if (!pilavacia()) {
            return datos[0];

        } else {
            throw new Exception("La Pila esta vacia");
        }

    }

    boolean pilavacia() {
        if (cima <= 0) {
            ///System.out.println("La pila esta vacia");
            return true;
        } else {
            //System.out.println("La pila no esta vacia");
            return false;
        }
    }

    boolean pilallena() {

        if (cima >= capacidad) {
            //System.out.println("La pila esta llena");
            return true;
        } else {
            //System.out.println("La pila tiene capacidad para minimo un elemento mas");
            return false;
        }

    }

}
