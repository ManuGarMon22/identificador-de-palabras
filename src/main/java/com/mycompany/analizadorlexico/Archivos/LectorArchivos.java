/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Archivos;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class LectorArchivos {
    
    
    public void LeerArchivo(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            text.append(linea +"\n");
        }
    }
}
