/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Manejadores;

import com.mycompany.analizadorlexico.Automatas.Automata;
import com.mycompany.analizadorlexico.Enums.TipoToken;
import com.mycompany.analizadorlexico.Modelos.Palabra;
import com.mycompany.analizadorlexico.Pila.AutomataPila;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class ManejadorTextos {
    
    private char[] letras;
    private ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
    int error =0;

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
        int columna = 1;
        int fila = 1;
        
        for(char x: letras){
            
            if(x=='\n'|| x=='\t'|| x=='\r' ||x=='\f'|| estado <0){               
                if(x=='\n'){
                  columna++;
                  fila = 1;
                }
                if(nueva.getLetras().size() > 0){
                    nueva.setPosicion(fila, columna);
                    this.listaPalabras.add(nueva);                
                    estado = 0;
                    nueva = new Palabra();
                    fila++;
                    auto = new Automata(info);
                }
                
            }else{
                if(estado == 0 && x == '('){
                    nueva.addLetter(x);
                    nueva.addState(10);
                    nueva.DefinirToken(10, x);
                    nueva.setPosicion(fila, columna);
                    this.listaPalabras.add(nueva);
                    estado = 0;
                    nueva = new Palabra();
                    fila++;
                    auto = new Automata(info);
                    
                    
                
                }else if((estado == 2 || estado == 3 ||estado == 5) && x ==')'){
                    nueva.setPosicion(fila, columna);
                    this.listaPalabras.add(nueva); 
                    
                    estado = 0;
                    nueva = new Palabra();
                    fila++;
                    auto = new Automata(info);
                    
                    nueva.addLetter(x);
                    nueva.addState(10);
                    nueva.DefinirToken(10, x);
                    nueva.setPosicion(fila, columna);
                    
                    nueva = new Palabra();
                    fila++;
                    auto = new Automata(info);
                    
                    
                }else{
                
                alfabetoTemp = auto.TipoCaracter(x);
                estadoTemp = auto.Trancision(alfabetoTemp, estado, x);
                estado = estadoTemp;
                
                    if(estado != 0){
                        if(x != ' '){
                        nueva.addLetter(x);
                        nueva.addState(estado);
                        nueva.DefinirToken(estado, alfabetoTemp);
                        nueva.setPosicion(fila, columna);
                        }
                    }
                
                }           
            }
            if (estado ==-1){
                if(x != ' '){    
                    error++;
                }
                    this.listaPalabras.add(nueva);
                    estado = 0;
                nueva = new Palabra();
                fila++;
                auto = new Automata(info);
                }
        }
        
        if(estado > 0){
        this.listaPalabras.add(nueva);
        }
        
        
        info.append("\n La evaluacion ha sido todo un exito\n");        
        
        for(Palabra r:this.listaPalabras){
            if(r.getToken() == TipoToken.ERROR){
                error++;
            }
        }
        
        
        if(error > 0){
            ReportePalabras.Errores(this.listaPalabras, info);
            info.append("\nArregle los errores del texto por favor");
        }else{
            JOptionPane.showMessageDialog(null, "El texto es aceptable, puede proceder con el analizador sintactico");
            AutomataPila ap = new AutomataPila(this.listaPalabras);
            ap.transicion(info);
        }        
    }

    public ArrayList<Palabra> getListaPalabras() {
        return listaPalabras;
    }

    public int getError() {
        return error;
    }
}
