/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Manejadores;

import com.mycompany.analizadorlexico.Automatas.Automata;
import com.mycompany.analizadorlexico.Modelos.Palabra;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class ManejadorTextos {
    
    private char[] letras;
    private ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
    

    public ManejadorTextos(JTextArea texto, JTextArea info) {
        SeparadorLetras s = new SeparadorLetras();
        this.letras = s.separarLetras(texto);
        this.evaluar(letras, info);
        
    }
    
    
    private void evaluar(char[] letras, JTextArea info ){
        Automata auto = new Automata(info);
        Palabra nueva = new Palabra();
        int estado = 0;
        int estadoTemp = 0;
        int alfabetoTemp =0;
       
        int error = 0;
        
        
        for(char x: letras){
            
            if(Character.isSpaceChar(x) || x=='\n'|| estado <0){               
                
                
                this.listaPalabras.add(nueva);
                
                estado = 0;
                nueva = new Palabra();
                auto = new Automata(info);
                
                
            }else {
                alfabetoTemp = auto.TipoCaracter(x);
                estadoTemp = auto.Trancision(alfabetoTemp, estado, x);
                estado = estadoTemp;
                
                nueva.addLetter(x);
                nueva.addState(estado);
                nueva.DefinirToken(estado, alfabetoTemp);
                      
                
            }           
            
            if (estado ==-1){
                    error++;
                    this.listaPalabras.add(nueva);
                    nueva.ReportePalabra(info);
                    estado = 0;
                nueva = new Palabra();
                auto = new Automata(info);
                }
        }
        this.listaPalabras.add(nueva);
        info.append("\n La evaluacion ha sido todo un exito");        
        
        if(error > 0){
            info.append("\nArregle los errores del texto por favor");
        }else{
            info.append("\nEl texto es aceptable");
        }        
    }

    public ArrayList<Palabra> getListaPalabras() {
        return listaPalabras;
    }
    
    
    
    
    
}
