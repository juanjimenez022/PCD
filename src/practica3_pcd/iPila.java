/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package practica3_pcd;

/**
 *
 * @author jujis
 */
public interface iPila {

    public int GetNum();

    public void Apila(Object obj) throws Exception;

    public Object Desapila() throws Exception;

    public Object Primero() throws Exception;
}
