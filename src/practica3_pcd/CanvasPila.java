/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3_pcd;

import java.awt.*;

/**
 *
 * @author jujis
 */
public class CanvasPila extends Canvas {

    private String estado_pila;
    private int cima;
    private Object datos[];

    public CanvasPila(int ancho, int alto) {
        this.setSize(ancho, alto);
        this.setBackground(Color.LIGHT_GRAY);
        estado_pila = "";
        cima = 0;
        datos = new Object[1];
    }

    @Override
    public void update(Graphics g) {

        paint(g);

    }

    public void avisa(String estado_pila) {
        this.estado_pila = estado_pila;
        repaint();
    }

    public void representa(int cima, Object[] datos) {
        this.cima = cima;
        this.datos = datos;
        estado_pila = "";
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        Font f1 = new Font("Arial", Font.BOLD, 30);

        Image img = createImage(getWidth(), getHeight());
        Graphics og = img.getGraphics();

        og.setFont(f1);
        og.setColor(Color.red);
        og.fillOval(50, 80, 30, 30);
        if (datos[cima] != null) {
            og.drawString("Contador = " + datos[cima], 100, 100);
            g.drawImage(img, 0, 0, null);
        } else if (estado_pila != "") {
            og.drawString("Contador = " + estado_pila, 100, 100);
            g.drawImage(img, 0, 0, null);
        }

    }

}
