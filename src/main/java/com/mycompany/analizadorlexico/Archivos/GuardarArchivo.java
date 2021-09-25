/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Archivos;

import javax.swing.JTextArea;
import java.io.*;

/**
 *
 * @author manu
 */
public class GuardarArchivo {
    private static int x = 1;
    
    public void Guardar(JTextArea texto)throws IOException{
        FileWriter archivo = new FileWriter("archivos/datos.txt");
        
        archivo.write(texto.getText());
        
        archivo.close();
        
    }
    
}
