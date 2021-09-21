/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Automatas;

/**
 *
 * @author manu
 */
public class Automata {
    
    private int[][] transiciones = new int[6][6];
    private static int numLetra = 0;
    private static int fila = 0;
    private static int columna = 0;
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
    }
    
    public void Trancisiones(){
        
        
    }
    
    
    
    
}
