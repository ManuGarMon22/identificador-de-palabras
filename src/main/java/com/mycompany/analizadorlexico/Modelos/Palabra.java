/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Modelos;

import java.util.ArrayList;
import javax.swing.JTextArea;
import com.mycompany.analizadorlexico.Enums.*;
/**
 *
 * @author manu
 */
public class Palabra {
    
    private ArrayList<Character> letras =  new ArrayList<Character>();
    private ArrayList<Integer> transicion = new ArrayList<Integer>();
    private TipoToken token = TipoToken.ERROR;
    private int columna = 0;
    private int fila = 0;
    
    //donde [letra][estado de trancicion]
    
    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }

    public ArrayList<Integer> getTransicion() {
        return transicion;
    }

    public void setTransicion(ArrayList<Integer> tanision) {
        this.transicion = tanision;
    }

    public TipoToken getToken() {
        return token;
    }

    public void setToken(TipoToken token) {
        this.token = token;
    }
    
    public void setPosicion(int columna, int fila){
        this.fila = fila;
        this.columna = columna;
    }

    public String getPosicion() {
        return " en fila: "+fila+", palabra no." +columna;
    }    
    
    public void addLetter( char x){
        Character l = x; 
        this.letras.add(l);
    }
    
    public void addState( int x){
        Integer n = x;
        this.transicion.add(n);
    }
    
    public void ReporteTransicion(JTextArea AreaReporte){
        if(this.letras.size() > 0){
        int temp = 0;
        for(int i = 0; i<letras.size(); i++){
            AreaReporte.append("Con "+this.letras.get(i)+ " pasamos del estado "+temp+" al estado "+this.transicion.get(i)+"\n");
            temp =this.transicion.get(i);
        }
        }
    }
    
    public void DefinirToken(int estado, int simbolo ){
        if(simbolo > -1){
        switch(estado){
            // case (estado de actacion): definir el tipo de token con el que coincide el estado de aceptacion
            // que definimos anteriormente en el automata
            case 5: this.token= TipoToken.IDENTIFICADOR;
                    this.PalbrasReservadas(); //metodo para comparrar si el id es una palabra reservada
                break;
            case 2: this.token= TipoToken.NEGATIVO;
                break;
            case 3: this.token= TipoToken.POSITIVO;
                break;
            case 9: this.token = TipoToken.COMENTARIO;
                break;
            case 7: this.token = TipoToken.LITERAL;
                break;
            case 10: this.token = TipoToken.SIMBOLO;
                    if(this.letras.get(0)=='('){
                        this.token = TipoToken.PA;
                    }else if(this.letras.get(0)==')'){
                        this.token = TipoToken.PC;
                    }else if(this.letras.size() == 1){
                        if(this.letras.get(0)== '+'){
                            this.token = TipoToken.SUMA;
                        }else if(this.letras.get(0)== '*'){
                            this.token = TipoToken.MULTI;
                        }else if(this.letras.get(0)== '='){
                            this.token = TipoToken.IGUAL;
                        }
                    }
                break;
            default:
                this.token = TipoToken.ERROR;
        }
        }else {
            this.token = TipoToken.ERROR;
        }
    }
    
    public void ReportePalabra(JTextArea area){
        if(this.letras.size()>0){
        this.MostrarPalabra(area);
        area.append(" - ");
        this.MostrarMensajeToken(area);
        }
    }
    
    public void MostrarPalabra(JTextArea area){
        for(Character x: this.letras){
            area.append(""+x);
        }
    }
    
    public void MostrarMensajeToken(JTextArea area){
        area.append(this.getToken().getMensaje());
    }
    
    //metodo para comparar palabras reservadas
    private void PalbrasReservadas(){
        if(this.letras.size() == 2){
            if(letras.get(0)== 'S' &&
               letras.get(1)== 'I'){
                    this.token = TipoToken.R_SI;
            }
        }else if(this.letras.size() == 3){
            if(letras.get(0)== 'F' &&
               letras.get(1)== 'I' && 
               letras.get(2)== 'N'){
                    this.token = TipoToken.R_FIN;
            }
        }else if(this.letras.size() == 5){
            if(letras.get(0)== 'F' &&
               letras.get(1)== 'A' &&
               letras.get(2)== 'L' &&
               letras.get(3)== 'S' &&
               letras.get(4)== 'O' ){
                this.token = TipoToken.R_FALSO;
            }
        }else if(this.letras.size() == 7){
            if(letras.get(0)== 'R' &&
               letras.get(1)== 'E' &&
               letras.get(2)== 'P' &&
               letras.get(3)== 'E' &&
               letras.get(4)== 'T' &&
               letras.get(5)== 'I' &&
               letras.get(6)== 'R'){
                this.token = TipoToken.R_REPETIR;
            }else if(letras.get(0)== 'I' &&
               letras.get(1)== 'N' &&
               letras.get(2)== 'I' &&
               letras.get(3)== 'C' &&
               letras.get(4)== 'I' &&
               letras.get(5)== 'A' &&
               letras.get(6)== 'R'){
                this.token = TipoToken.R_INICIAR;
            }
        }else if(this.letras.size() == 8){
            if(letras.get(0)== 'E' &&
               letras.get(1)== 'N' &&
               letras.get(2)== 'T' &&
               letras.get(3)== 'O' &&
               letras.get(4)== 'N' &&
               letras.get(5)== 'C' &&
               letras.get(6)== 'E' &&
               letras.get(7)== 'S'){
                this.token = TipoToken.R_ENTONCES;
            }else if(letras.get(0)== 'E' &&
               letras.get(1)== 'S' &&
               letras.get(2)== 'C' &&
               letras.get(3)== 'R' &&
               letras.get(4)== 'I' &&
               letras.get(5)== 'B' &&
               letras.get(6)== 'I' &&
               letras.get(7)== 'R'){
                this.token = TipoToken.R_ESCRIBIR;
            }
        }else if(this.letras.size() == 9){
            if(letras.get(0)== 'V' &&
               letras.get(1)== 'E' &&
               letras.get(2)== 'R' &&
               letras.get(3)== 'D' &&
               letras.get(4)== 'A' &&
               letras.get(5)== 'D' &&
               letras.get(6)== 'E' &&
               letras.get(7)== 'R' &&
               letras.get(8)== 'O'){
                this.token = TipoToken.R_VERDADERO;
            }       
        }
    }
}
