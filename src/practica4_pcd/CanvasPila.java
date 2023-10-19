/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_pcd;

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
        estado_pila = "La pila esta vacia";
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
        for (int i = 0; i < cima; i++) {

            og.drawString(" " + datos[i], 100+i*100, 100);
        }
        og.drawString("Puntero a posicion = " + cima, 100, 150);
        g.drawImage(img, 0, 0, null);

    }

}
