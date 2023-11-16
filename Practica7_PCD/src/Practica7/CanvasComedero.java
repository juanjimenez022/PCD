/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica7;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author jujis
 */
public class CanvasComedero extends Canvas {

    private ArrayList<String> colaEsperaGatos;
    private ArrayList<String> colaEsperaPerros;
    private ArrayList<String> GC;
    private ArrayList<String> PC;

    private int NPerros = 0;
    private int NGatos = 0;

    CanvasComedero(int Ancho, int Alto) {
        this.setSize(Ancho, Alto);
    }

    public void actualizar(ArrayList<String> GC, ArrayList<String> PC, ArrayList<String> CEG, ArrayList<String> CEP, int NG, int NP) {

        this.GC = GC;
        this.PC = PC;
        this.colaEsperaGatos = CEG;
        this.colaEsperaPerros = CEP;
        this.NGatos = NG;
        this.NPerros = NP;
        repaint();

    }

    @Override
    public void paint(Graphics g) {

        Font f1 = new Font("Arial", Font.BOLD, 30);

        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();

        og.setFont(f1);
        og.setColor(Color.darkGray);
        
        int a=355;
        int b=355;
        
        og.drawString("Gatos en espera: ", 100, 100);

        for (int i = 0; i < colaEsperaGatos.size(); i++) {
            og.drawString("" + colaEsperaGatos.get(i), a, 100);
            a=a+75;

        }

        og.drawString("Perros en espera: ", 100, 150);
        for (int i = 0; i < colaEsperaPerros.size(); i++) {
            og.drawString("" + colaEsperaPerros.get(i), b, 150);
            b=b+75;
        }

        og.drawString("Gatos comiendo: " + NGatos, 100, 200);
        og.drawString("Perros comiendo: " + NPerros, 100, 250);

        og.drawString("Comedero: ", 100, 325);

        og.drawString("Gatos: ", 275, 300);
        int x=400;
        int j=400;
        for (int i = 0; i < GC.size(); i++) {
            og.drawString("" + GC.get(i), x, 300);
            x=x+75;
        }

        og.drawString("Perros: ", 275, 350);
        for (int i = 0; i < PC.size(); i++) {
            og.drawString(""+PC.get(i), j, 350);
            j=j+75;

        }

        g.drawImage(img, 0, 0, null);

    }

}
