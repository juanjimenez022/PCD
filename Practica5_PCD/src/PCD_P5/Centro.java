/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCD_P5;

import java.util.ArrayList;

/**
 *
 * @author jujis
 */
public class Centro {

    CanvasCentro canvas;

    public Centro(CanvasCentro canvas) {

        this.canvas = canvas;

    }

    private boolean MasajistaOcupado = false;
    private boolean RehabilitadorOcupado = false;
    private boolean vestuarioOcupado = false;
    private boolean rehabilito = false;
    private ArrayList<String> ColaMasaje = new ArrayList<String>();
    private ArrayList<String> ColaRehabilitacion = new ArrayList<String>();

    public synchronized void EntraMasaje(String cliente) throws InterruptedException {

        canvas.actualizacolamasaje(ColaMasaje);
        canvas.actualizacolaRehabilitacion(ColaRehabilitacion);
        ColaMasaje.add(cliente);
        //canvas.actualizacolamasaje(ColaMasaje);
        while (MasajistaOcupado && RehabilitadorOcupado) {
            wait();
        }
        
            ColaMasaje.remove(0);
        

        //canvas.actualizacolamasaje(ColaMasaje);
        if (!MasajistaOcupado) {
            MasajistaOcupado = true;
            canvas.ocuparMasaje(cliente);
        } else {
            rehabilito = true;
            RehabilitadorOcupado = true;
            canvas.ocuparRehabilitacion(cliente);
        }

    }

    public synchronized void SaleMasaje(String cliente) throws InterruptedException {

        while (vestuarioOcupado) {
            wait();
        }

        if (rehabilito) {

            rehabilito = false;
            RehabilitadorOcupado = false;
            vestuarioOcupado = true;
            canvas.desocuparRehabilitacion();
            canvas.ocuparVestuario(cliente);

        } else {
            MasajistaOcupado = false;
            vestuarioOcupado = true;
            canvas.desocuparMasaje();
            canvas.ocuparVestuario(cliente);

        }
        notifyAll();
    }

    public synchronized void EntraRehabilitacion(String cliente) throws InterruptedException {

        ColaRehabilitacion.add(cliente);
        //canvas.actualizacolaRehabilitacion(ColaRehabilitacion);

        while (RehabilitadorOcupado) {
            wait();
        }
        
        
        ColaRehabilitacion.remove(0);
        
        RehabilitadorOcupado = true;
        //canvas.actualizacolaRehabilitacion(ColaRehabilitacion);
        canvas.ocuparRehabilitacion(cliente);
    }

    public synchronized void SaleRehabilitacion(String cliente) throws InterruptedException {
        while (vestuarioOcupado) {
            wait();
        }
        RehabilitadorOcupado = false;
        vestuarioOcupado = true;
        canvas.desocuparRehabilitacion();
        canvas.ocuparVestuario(cliente);
        notifyAll();
    }

    public synchronized void Termina() {
        vestuarioOcupado = false;
        notifyAll();
        canvas.desocuparVestuario();
    }
}
