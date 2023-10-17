/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3_pcd;

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
    public synchronized void Apila(Object elemento) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("no se ha podido dormir");
        }
        if (!pilallena()) {

            datos[cima] = elemento;
            numelementos++;
            CP.representa(cima, datos);
            System.out.println("Apilo el elemento numero " + numelementos + " que contendra a " + elemento);
            cima++;
        } else {
            CP.avisa("La pila esta llena");
        }

    }

    @Override
    public synchronized Object Desapila() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("No se ha podido dormir");
        }

        Object aux = null;
        if (!pilavacia()) {

            cima--;
            aux = datos[cima];
            System.out.println("Obtengo el elemento " + numelementos + " al Desapilar " + datos[cima]);
            CP.representa(cima, datos);
            datos[cima] = null;
            numelementos--;
            return aux;
        } else {

            CP.avisa("La pila esta vacia");
        }
        return aux;
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
            System.out.println("La pila esta vacia");
            return true;
        } else {
            System.out.println("La pila no esta vacia");
            return false;
        }
    }

    boolean pilallena() {

        if (cima >= capacidad) {
            System.out.println("La pila esta llena");
            return true;
        } else {
            System.out.println("La pila tiene capacidad para minimo un elemento mas");
            return false;
        }

    }

}
