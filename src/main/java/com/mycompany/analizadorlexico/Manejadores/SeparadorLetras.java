/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Manejadores;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class SeparadorLetras {
    
    public char[] separarLetras(JTextArea areaTexto){
        
        char[] letras;
        letras  = areaTexto.getText().toCharArray();
        
        
        return letras;
    }
    
}
