/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCD_P5;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author jujis
 */
public class CanvasCentro extends Canvas {

    private String clienteMasaje = "";
    private String clienteRehabilitacion = "";
    private String clienteVestuario = "";
    private ArrayList<String> espMasaje = new ArrayList<>();
    private ArrayList<String> espRehabilitacion = new ArrayList<>();

    public CanvasCentro(int Ancho, int Alto) {
        this.setSize(Ancho, Alto);        
    }

    public void actualizacolamasaje(ArrayList<String> ColaMasaje) {

        this.espMasaje = ColaMasaje;
        repaint();

    }

    public void actualizacolaRehabilitacion(ArrayList<String> colaRehabilitacion) {

        this.espRehabilitacion = colaRehabilitacion;
        repaint();

    }

    public void ocuparMasaje(String cliente) {

        clienteMasaje = cliente;
        repaint();
    }

    public void ocuparRehabilitacion(String cliente) {

        clienteRehabilitacion = cliente;

        repaint();
    }

    public void ocuparVestuario(String cliente) {
        clienteVestuario = cliente;
        repaint();
    }

    public void desocuparMasaje() {
        clienteMasaje = "";
        clienteMasaje = this.espMasaje.get(0);
        this.espMasaje.remove(0);

        repaint();
    }

    public void desocuparRehabilitacion() {
        clienteRehabilitacion = "";
        clienteRehabilitacion = this.espRehabilitacion.get(0);
        this.espRehabilitacion.remove(0);

        repaint();
    }

    public void desocuparVestuario() {
        clienteVestuario = "";
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        Font f1 = new Font("Arial", Font.BOLD, 30);
        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();

        og.setFont(f1);
        og.setColor(Color.lightGray);
        og.fillRect(0, 0, getWidth(), getHeight());

        og.setColor(Color.darkGray);

        og.drawString("Masaje: ", 50, 150);
        og.drawString("Rehabilitación: ", 50, 200);
        og.drawString("Vestuario: ", 50, 250);

        og.drawString(clienteMasaje, 275, 150);
//        g.drawImage(img, 0, 0, null);

        og.drawString(clienteRehabilitacion, 275, 200);
//        g.drawImage(img, 0, 0, null);

        og.drawString(clienteVestuario, 275, 250);
//        g.drawImage(img, 0, 0, null);

        int x = 410;
        int j = 410;
        String espera;

        og.drawString("Espera para masaje :", 0, 50);
        for (int i = 0; i < espMasaje.size(); i++) {
            espera = espMasaje.get(i);
            og.drawString(espera, x, 50);
            x = x + 70;
        }

        og.drawString("Espera para Rehabilitación :", 0, 100);
        for (int i = 0; i < espRehabilitacion.size(); i++) {
            espera = espRehabilitacion.get(i);
            og.drawString(espera, j, 100);
            j = j + 70;
        }
        g.drawImage(img, 0, 0, null);

    }

}
