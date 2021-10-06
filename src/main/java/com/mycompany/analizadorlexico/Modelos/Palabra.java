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
    private ArrayList<Integer> tanision = new ArrayList<Integer>();
    private TipoToken token = TipoToken.ERROR;
    private int tok;
    //donde [letra][estado de trancicion]

    
    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }

    public ArrayList<Integer> getTanision() {
        return tanision;
    }

    public void setTanision(ArrayList<Integer> tanision) {
        this.tanision = tanision;
    }

    public int getTok() {
        return tok;
    }

    public TipoToken getToken() {
        return token;
    }
    
    public void addLetter( char x){
        Character l = x; 
        this.letras.add(l);
    }
    
    public void addState( int x){
        Integer n = x;
        this.tanision.add(n);
    }
    
    
    public void ReporteTransicion(JTextArea AreaReporte){
        if(this.letras.size() > 0){
        int temp = 0;
        for(int i = 0; i<letras.size(); i++){
            AreaReporte.append("Con "+this.letras.get(i)+ " pasamos del estado "+temp+" al estado "+this.tanision.get(i)+"\n");
            temp =this.tanision.get(i);
        }
        }
    }
    
    public void DefinirToken(int estado, int simbolo ){
        if(simbolo > -1){
        switch(estado){
            case 1: this.token= TipoToken.IDENTIFICADOR;
                break;
            case 2: this.token= TipoToken.ENTERO;
                break;
            case 4: this.token= TipoToken.DECIMAL;
                break;
            case 3: this.token = TipoToken.ERROR;
                break;
            case 5: 
                switch(simbolo){
                    case 2: this.token = TipoToken.PUNTUACION;
                        break;
                    case 3: this.token = TipoToken.PUNTUACION;
                        break;
                    case 4: this.token = TipoToken.OPERADOR;
                        break;
                    case 5: this.token = TipoToken.AGRUPACION;
                        break;
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
        area.append(this.getToken().getMensaje()+"\n");
    }
}
