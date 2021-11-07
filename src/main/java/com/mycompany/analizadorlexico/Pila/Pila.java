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
    public void Insertar(String valor){
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
    public String extraer(){
        if (UltimoValorIngresado != null) {
            
            String informacion = UltimoValorIngresado.getInfo();
            UltimoValorIngresado = UltimoValorIngresado.getSiguiente();
            return informacion;
            
        } else {
            return " ";
        }
    }
    
    //Método para saber si la pila esta vacia
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
}
