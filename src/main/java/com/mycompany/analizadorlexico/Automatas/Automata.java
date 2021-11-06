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
    
    private int[][] transiciones = new int[11][8];
    private int[] aceptacion= new int[6];
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
    //  alfabeto: 0-- letra         1-- numero  
    //            2-- guion (-)     3-- guion bajo ( _ )
    //            4-- diagonal(/)   5-- comiilas (")        
    //            6-- cualquier otro simbolo 
    //            7-- esapcio en blanco (no saltos de linea y demas) 
    
    
    
    {
        //TRANSICIONES DESDE EL ESTADO 0
    transiciones[0][0]= 4; transiciones[0][1]= 3; transiciones[0][2]= 1; 
    transiciones[0][3]= 4; transiciones[0][4]= 8; transiciones[0][5]= 6; 
    transiciones[0][6]=10; transiciones[0][7]= 0;
        //TRANSICIONES DESDE EL ESTADO 1
    transiciones[1][0]= -1; transiciones[1][1]= 2; transiciones[1][2]= -1; 
    transiciones[1][3]= -1; transiciones[1][4]=-1; transiciones[1][5]= -1; 
    transiciones[1][6]= -1; transiciones[1][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 2 : ACEPTACION NUMERO NEGATIVO
    transiciones[2][0]= -1; transiciones[2][1]= 2; transiciones[2][2]= -1; 
    transiciones[2][3]= -1; transiciones[2][4]=-1; transiciones[2][5]= -1; 
    transiciones[2][6]= -1; transiciones[2][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 3 : ACEPTACION NUMERO POSITIVO
    transiciones[3][0]= -1; transiciones[3][1]= 3; transiciones[3][2]= -1; 
    transiciones[3][3]= -1; transiciones[3][4]=-1; transiciones[3][5]= -1; 
    transiciones[3][6]= -1; transiciones[3][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 4   
    transiciones[4][0]= 5; transiciones[4][1]= 5; transiciones[4][2]= 5; 
    transiciones[4][3]= 5; transiciones[4][4]=-1; transiciones[4][5]= -1; 
    transiciones[4][6]=-1; transiciones[4][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 5 : ACEPTACION, ID
    transiciones[5][0]= 5; transiciones[5][1]= 5; transiciones[5][2]= 5; 
    transiciones[5][3]= 5; transiciones[5][4]=-1; transiciones[5][5]=-1; 
    transiciones[5][6]=-1; transiciones[5][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 6
    transiciones[6][0]= 6; transiciones[6][1]= 6; transiciones[6][2]= 6; 
    transiciones[6][3]= 6; transiciones[6][4]= 6; transiciones[6][5]= 7; 
    transiciones[6][6]= 6; transiciones[6][7]= 6;
        
        //TRANSICIONES DESDE EL ESTADO 7 : ACEPTACION LITERAL
    transiciones[7][0]= -1; transiciones[7][1]= -1; transiciones[7][2]= -1; 
    transiciones[7][3]= -1; transiciones[7][4]= -1; transiciones[7][5]= -1; 
    transiciones[7][6]= -1; transiciones[7][7]= -1;
        //TRANSICIONES DESDE EL ESTADO 8
    transiciones[8][0]= -1; transiciones[8][1]= -1; transiciones[8][2]= -1; 
    transiciones[8][3]= -1; transiciones[8][4]= 9; transiciones[8][5]= -1; 
    transiciones[8][6]= -1; transiciones[8][7]=-1;
        //TRANSICIONES DESDE EL ESTADO 9 : ACEPTACION COMENTARIO
    transiciones[9][0]= 9; transiciones[9][1]= 9; transiciones[9][2]= 9; 
    transiciones[9][3]= 9; transiciones[9][4]= 9; transiciones[9][5]= 9; 
    transiciones[9][6]= 9; transiciones[9][7]= 9;
        //TRANSICIONES DESDE EL ESTADO 10 
    transiciones[10][0]= -1; transiciones[10][1]= -1; transiciones[10][2]= -1; 
    transiciones[10][3]= -1; transiciones[10][4]= -1; transiciones[10][5]= -1; 
    transiciones[10][6]= -1; transiciones[10][7]= -1;
    
    
    aceptacion[0]=2; // NUMERO NEGATIVO
    aceptacion[1]=3; // NUMERO POSITIVO
    aceptacion[2]=5; // ID
    aceptacion[3]=7; // LITERAL
    aceptacion[4]=9; // COMENTARIO 
    aceptacion[5]=10;//simbolo
    
    }
    
    //
    //alfabeto a usar:
        private final char[] simbolos= {'.',',',';',':','+','*',
            '%','(',')','{','}','[',']', ' '};
    //
       
    public Automata(JTextArea receptorTexto){
        this.verInfo = receptorTexto;
    }
        
    public int Trancision(int alfabeto, int estadoActual, char v){
       
        if(alfabeto != -1){
            
            if((alfabeto == 2 || alfabeto == 3 ||alfabeto == 4 || alfabeto == 5)&& estado == 0){
                estado = 10;
            }else{
                estado = transiciones[estadoActual][alfabeto];
            }
            
        }else{
            this.verInfo.append("Error, simbolo -"+v+"- no pertenece al alfabeto\n");
        }
            
        return estado;
        
        
    }
    
    
    //metodo para definir el tipo de caracter que se encuentra en el char 
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
        }else if(letra == '-'){
            tipo = 2;
        }else if(letra == '_'){
            tipo = 3;
        }else if(letra == '/'){
            tipo = 4;
        }else if(letra == '"'){
            tipo = 5;    
        }else if(letra == ' '){
            tipo = 7;    
        }
        else{
            tipo = 6;
        }
        
        return tipo;
    }
   
    //codigo posiblemente inservible
     /*
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
    }*/  

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
