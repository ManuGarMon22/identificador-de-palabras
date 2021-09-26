/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Manejadores;

import com.mycompany.analizadorlexico.Automatas.Automata;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class ManejadorTextos {
    
    private char[] letras;

    public ManejadorTextos(JTextArea texto, JTextArea info) {
        SeparadorLetras s = new SeparadorLetras();
        this.letras = s.separarLetras(texto);
        this.evaluar(letras, info);
        
    }
    
    
    private void evaluar(char[] letras, JTextArea info ){
        Automata auto = new Automata(info);
        int estado = 0;
        int estadoTemp = 0;
        int alfabetoTemp =0;
        
        for(char x: letras){
            
            if(Character.isSpaceChar(x) || x=='\n'){               
                auto.MensajeFinal(estado);
                estado = 0;
                
            }else {
                alfabetoTemp = auto.TipoCaracter(x);
                estadoTemp = auto.Trancision(alfabetoTemp, estado);
                estado = estadoTemp;
            }             
        }      
        auto.MensajeFinal(estado);
    }
    
    
    
    
    
}
