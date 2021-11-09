/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Pila;

import javax.swing.JOptionPane;

/**
 *
 * @author manu
 */
public class Pila {
    
    private Nodo UltimoValorIngresado;
    
    public Pila(){
        UltimoValorIngresado = null;
    }
    
    
    //Método para insertar dentro de la pila
    public void Insertar(int valor){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setInfo(valor);
        
        if (UltimoValorIngresado == null) {
            
            nuevo_nodo.setSiguiente( null);
            UltimoValorIngresado = nuevo_nodo;
            
        } else {
            
            nuevo_nodo.setSiguiente(UltimoValorIngresado); 
            UltimoValorIngresado = nuevo_nodo;
        }
    }
    
    //Método para extraer de la pila
    public int extraer(){
        if (UltimoValorIngresado != null) {
            
            int informacion = UltimoValorIngresado.getInfo();
            UltimoValorIngresado = UltimoValorIngresado.getSiguiente();
            return informacion;
            
        } else {
            return -1;
        }
    }
    
    public int EliminarNodo(){
        int auxiliar = UltimoValorIngresado.getInfo();
        UltimoValorIngresado = UltimoValorIngresado.getSiguiente();
        return auxiliar;
    }
    
    public int getUltimoValorIngresado(){
        return UltimoValorIngresado.getInfo();
    }
    
    //Método para saber si la pila esta vacia
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
    
    public void VaciarPila(){
        while (!PilaVacia()) {
            EliminarNodo();            
        }
    }
}
