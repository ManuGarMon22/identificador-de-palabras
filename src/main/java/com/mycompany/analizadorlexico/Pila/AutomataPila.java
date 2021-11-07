/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Pila;

import com.mycompany.analizadorlexico.Enums.TipoToken;
import com.mycompany.analizadorlexico.Modelos.Palabra;
import java.util.ArrayList;

/**
 *
 * @author manu
 * 
 * para entender del todo el funcionamiento del automata de pila necesitaremos apoyarnos en el trabajo teorico-practico
 */
public class AutomataPila {
    
    private Pila pila;
    
    private int tokenActual, tokenPalabra, numeroPalabra;
    private TipoToken Actual;
    
    private int[] token = new int[17]; 
     
    // donde cada estado representa letra para la trancision en la gramatica
    private int[] estado = new int[34];
    
    private ArrayList<Palabra> palabras;
    
    public AutomataPila( ArrayList<Palabra> palabras){
        this.LlenarMatrices();
        this.palabras = palabras;
    }
    // metodo para llenar la matrices con numeros sin la necesidad de escribirlo en cada linea de codigo  
    private void LlenarMatrices(){
        for(int i = 0; i< token.length ; i++){
            token[i] = (i+1);
        }
        
        for(int i = 0; i< estado.length ; i++){
            estado[i]= (i+1);
        }
    }
    
    
    
    private void transicion(Palabra x){
        
    }
    
    
}
