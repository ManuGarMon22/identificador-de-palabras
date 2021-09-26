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
    private static int numLetra = 0;
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
        
    public int Trancision(int alfabeto, int estadoActual){
        int estado = transiciones[estadoActual][alfabeto];
        
        if(estado>0){
            
        }else{
            estado=0;
        }
        
            
        return estado;
    }
    
    public int TipoCaracter(char letra){
        int tipo = -1; 
        if(Character.isSpaceChar(letra)){
            tipo = -2;
            if(letra == '\n'){
                fila++;
                columna = 0;
            }else if(letra == ' '){
                columna++;
            }
            
        }else if(Character.isLetter(letra)){
           tipo = 0;
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
   
    
    public void MensajeFinal(int estado){
        switch(estado){
            case 1:this.verInfo.setText("es un identificador");
                break;
            case 2:this.verInfo.setText("es un numero entero");
                break;
            case 4:this.verInfo.setText("es un numero decimal");
                break;
            case 5:this.verInfo.setText("es un signo"+this.tipoSimbolo);            
                break;
            default:
                this.verInfo.setText("Error, token no identificado");
        }
        
        
    }
    
}
