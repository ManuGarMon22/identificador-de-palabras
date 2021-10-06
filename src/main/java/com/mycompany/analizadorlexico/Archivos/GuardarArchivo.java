/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Archivos;

import javax.swing.JTextArea;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author manu
 */
public class GuardarArchivo {
    private static int x = 1;
    
    public void Guardar(JTextArea texto, String nombre)throws IOException{
        FileWriter archivo = new FileWriter("archivos/"+nombre+".txt");
        
        archivo.write(texto.getText());
        
        archivo.close();
        
        JOptionPane.showMessageDialog(null, "Archivo guardado con exito!\nPuede encontrar en el carpeta -archivos- que esta dentro de la carpeta de este proyecto");
        
    }
    
}
