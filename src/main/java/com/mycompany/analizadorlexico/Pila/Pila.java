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
    
    private Nodo Ultimo;
    private int tamano = 0;
    private String lista = "";
    
    public Pila(){
        Ultimo = null;
        tamano = 0;
    }
    
    //Método para saber cuando la pila esta vacia
    public boolean PilaVacia(){
        return Ultimo == null;
    }
    
    //Método para insertar un nodo en la pila
    public void InsertarNodo(String nodo){
        Nodo nuevoNodo = new Nodo(nodo);
        nuevoNodo.setSiguiente(Ultimo);
        Ultimo = nuevoNodo;
        tamano++;
    }        
    
    //Método para eliminar un nodo de la pila
    public String EliminarNodo(){
        String auxiliar = Ultimo.getInfo();
        Ultimo = Ultimo.getSiguiente();
        tamano--;
        return auxiliar;
    }
    
    //Método para conocer cual es el último valor ingresado
    public String MostrarUltimoValorIngresado(){
        return Ultimo.getInfo();
    }
    
    //Método para conocer el tamaño de la Pila
    public int TamanoPila(){
        return tamano;
    }
    
    //Método para vaciar la Pila
    public void VaciarPila(){
        while (!PilaVacia()) {
            EliminarNodo();            
        }
    }
    
    //Método para mostrar el contenido de la pila
    public void MostrarValores(){
        Nodo recorrido = Ultimo;
        
        while(recorrido != null){
            this.lista += recorrido.getInfo() + "\n";
            recorrido = recorrido.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }
}
