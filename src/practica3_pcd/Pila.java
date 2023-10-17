/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3_pcd;

/**
 *
 * @author jujis
 */
public class Pila implements iPila {

    int cima = 0;
    int capacidad = 0;
    int numelementos = 0;
    Object datos[];

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        datos = new Object[capacidad];
    }

    @Override
    public int GetNum() {
        System.out.println("Obtengo el numero de elementos de la pila "+numelementos);
        return numelementos;
    }

    @Override
    public void Apila(Object elemento) throws Exception {
        
        if (!pilallena()) {
            
            datos[numelementos] = elemento;
            numelementos++;
            System.out.println("Apilo el elemento numero "+numelementos+" que contendra a "+elemento);

        } else {
            throw new Exception("La pila esta llena");
        }

    }

    @Override
    public Object Desapila() throws Exception {

        
        if (!pilavacia()) {
            
            numelementos--;
            System.out.println("Obtengo el elemento "+numelementos+" al Desapilar "+datos[numelementos]);
            return datos[numelementos];
        } else {
            throw new Exception("No se puede desapilar, pues la fila esta vacia");
        }

    }

    @Override
    public Object Primero() throws Exception {

        if (!pilavacia()) {
            System.out.println("Intento obtener el primer elemento de la pila "+datos[0]);
            return datos[0];

        } else {
            throw new Exception("La Pila esta vacia");
        }

    }

    boolean pilavacia() {
        if (numelementos == 0) {
            System.out.println("La pila esta vacia");
            return true;
        } else {
            System.out.println("La pila no esta vacia");
            return false;
        }
    }

    boolean pilallena() {
        if (numelementos == capacidad) {
            System.out.println("La pila esta llena");
            return true;
        } else {
            System.out.println("La pila tiene capacidad para minimo un elemento mas");
            return false;
        }

    }

}
