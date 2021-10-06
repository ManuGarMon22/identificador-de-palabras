/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Automatas;

import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class Automata {
    
    private int[][] transiciones = new int[6][6];
    private int[] aceptacion= new int[4];
    private String tipoSimbolo;
    private static int estado = 0;
    private static int fila = 0;
    private static int columna = 0;
    private JTextArea verInfo;
    //  
    //  Transiciones[estado en el que se encuentra][alfabeto]
    //  donde el resultado es cambio de estado  
    //  donde el resultado es el cambio de estado y -1 significa que no funciona para el automata
    //
    
    
    {
    transiciones[0][0]= 1; transiciones[1][0]= 1; transiciones[2][0]=-1; transiciones[3][0]=-1; transiciones[4][0]=-1; transiciones[5][0]=-1;
    transiciones[0][1]= 2; transiciones[1][1]= 1; transiciones[2][1]= 2; transiciones[3][1]= 4; transiciones[4][1]= 4; transiciones[5][1]=-1;
    transiciones[0][2]= 5; transiciones[1][2]=-1; transiciones[2][2]= 3; transiciones[3][2]=-1; transiciones[4][2]=-1; transiciones[5][2]=-1;
    transiciones[0][3]= 5; transiciones[1][3]=-1; transiciones[2][3]=-1; transiciones[3][3]=-1; transiciones[4][3]=-1; transiciones[5][3]=-1;
    transiciones[0][4]= 5; transiciones[1][4]=-1; transiciones[2][4]=-1; transiciones[3][4]=-1; transiciones[4][4]=-1; transiciones[5][4]=-1;
    transiciones[0][5]= 5; transiciones[1][5]=-1; transiciones[2][5]=-1; transiciones[3][5]=-1; transiciones[4][5]=-1; transiciones[5][5]=-1;
    
    aceptacion[0]=1;
    aceptacion[1]=2;
    aceptacion[2]=4;
    aceptacion[3]=5;
    
    }
    
    //
    //alfabeto a usar:
        private final char[] simbolosPuntuacion= {'.',',',';',':'};
        private final char[] simbolosMatematicos= {'+','-','*','/','%'};
        private final char[] simbolosAgrupacion= {'(',')','{','}','[',']'};
    //
       
    public Automata(JTextArea receptorTexto){
        this.verInfo = receptorTexto;
    }
        
    public int Trancision(int alfabeto, int estadoActual, char v){
        
        if(alfabeto != -1){
            estado = transiciones[estadoActual][alfabeto];

            if(estado>0){

            }else if (estado == -1) {
                
                
            }
        }if(alfabeto == -1){
            this.verInfo.append("Error, simbolo -"+v+"- no pertenece al alfabeto\n");
        }
            
        return estado;
        
        
    }
    
    public int TipoCaracter(char letra){
        int tipo = -1; 
        if(Character.isLetter(letra)){
           tipo = 0;
           if(letra == 'ñ'){
               tipo = -1;
           }
           columna++;
        }else if(Character.isDigit(letra)){
            tipo = 1;
            columna++;
        }else{
            for(char x: this.simbolosPuntuacion){
                if(x == letra){
                    if(letra == '.'){
                        tipo = 2;
                        this.tipoSimbolo=" de Puntuacion";
                        columna++;
                        break;
                    }else{
                        tipo = 3;
                        this.tipoSimbolo=" de Puntuacion";
                        columna++;
                        break;
                    }
                }   
            }for(char x: this.simbolosMatematicos){
                if(x == letra){
                    tipo = 4;
                    this.tipoSimbolo=" Aritmetico";
                    columna++;
                    break;
                }   
            }for(char x: this.simbolosAgrupacion){
                if(x == letra){                   
                    tipo = 5;
                    this.tipoSimbolo=" de Agrupación";
                    columna++;
                    break;
                }   
            }
        }
        return tipo;
    }
    
    public void MensjeAutomata(int estadoInicial, int estadoFinal, int caracter ){
        
    }
   
    
    public void MensajeFinalx(int estado){
        switch(estado){
            case 0:
                break;
            case 1:this.verInfo.append("es un identificador\n" );
                break;
            case 2:this.verInfo.append("es un numero entero\n");
                break;
            case 4:this.verInfo.append("es un numero decimal\n");
                break;
            case 5:this.verInfo.append("es un signo"+this.tipoSimbolo+"\n");            
                break;
            default:
                this.verInfo.append("Error, token no identificado\n");
                this.estado = 0;
        }  
    }

    public static int getFila() {
        return fila;
    }

    public static void setFila(int fila) {
        Automata.fila = fila;
    }

    public static int getColumna() {
        return columna;
    }

    public static void setColumna(int columna) {
        Automata.columna = columna;
    }
    
    
    
}
