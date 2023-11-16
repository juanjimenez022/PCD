/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica7;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jujis
 */
public class Comedero {

    private final int N = 4;  // Definir el límite total de animales
    private int NPerros = 0;
    private int NGatos = 0;

    private Lock lock = new ReentrantLock();
    private Condition colaGato = lock.newCondition();
    private Condition colaPerro = lock.newCondition();
    private ArrayList<String> colaEsperaGatos = new ArrayList<>();
    private ArrayList<String> GatosComedero = new ArrayList<>();
    private ArrayList<String> colaEsperaPerros = new ArrayList<>();
    private ArrayList<String> PerrosComedero = new ArrayList<>();

    private CanvasComedero canvas;

    public Comedero(CanvasComedero canvas) {
        this.canvas = canvas;
        canvas.actualizar(GatosComedero, PerrosComedero, colaEsperaGatos, colaEsperaPerros, NGatos, NPerros);

    }

    public void EntraGato(String id) throws InterruptedException {
        lock.lock();
        try {
            while (NPerros + NGatos == N || NPerros == 3 || (NGatos == 2 && NPerros == 1)) {
                // Esperar mientras las condiciones no se cumplan
                colaEsperaGatos.add(id);
                colaGato.await();
            }
            GatosComedero.add(id);
            NGatos++;
            canvas.actualizar(GatosComedero, PerrosComedero, colaEsperaGatos, colaEsperaPerros, NGatos, NPerros);
        } finally {
            lock.unlock();
        }
    }

    public void SaleGato() {
        lock.lock();
        try {
            NGatos--;
            GatosComedero.remove(0);
            if (!colaEsperaGatos.isEmpty()) {
                colaEsperaGatos.remove(0);
                colaGato.signal();
            } else if (!colaEsperaPerros.isEmpty()) {
                colaEsperaPerros.remove(0);
                colaPerro.signal();
            } else {
                colaGato.signal();
                colaPerro.signal();
            }
            canvas.actualizar(GatosComedero, PerrosComedero, colaEsperaGatos, colaEsperaPerros, NGatos, NPerros);

        } finally {
            lock.unlock();
        }
    }

    public void EntraPerro(String id) throws InterruptedException {
        lock.lock();
        try {
            while (NPerros + NGatos == N || NGatos == 3 || (NPerros == 2 && NGatos == 1)) {
                // Esperar mientras las condiciones no se cumplan
                colaEsperaPerros.add(id);
                colaPerro.await();
            }
            NPerros++;
            PerrosComedero.add(id);
            canvas.actualizar(GatosComedero, PerrosComedero, colaEsperaGatos, colaEsperaPerros, NGatos, NPerros);

        } finally {
            lock.unlock();
        }
    }

    public void SalePerro() {
        lock.lock();
        try {
            NPerros--;
            PerrosComedero.remove(0);
            if (!colaEsperaPerros.isEmpty()) {
                colaEsperaPerros.remove(0);
                colaPerro.signal();
            } else if (!colaEsperaGatos.isEmpty()) {
                colaEsperaGatos.remove(0);
                colaGato.signal();
            }
            canvas.actualizar(GatosComedero, PerrosComedero, colaEsperaGatos, colaEsperaPerros, NGatos, NPerros);

        } finally {
            lock.unlock();
        }
    }
}
