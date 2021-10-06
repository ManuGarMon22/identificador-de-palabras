/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Manejadores;

import com.mycompany.analizadorlexico.Modelos.Palabra;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author manu
 */
public class ReportePalabras {
    
    private JTextArea area;
    private ArrayList<Palabra> palabras;
    
    public ReportePalabras(ArrayList<Palabra> palabras, JTextArea area){
        this.area = area;
        this.palabras = palabras;
        
    }
    
   
    public void Tokens(){
        this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
        for(Palabra p: palabras){
            p.ReportePalabra(area);
            this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
        }
        
        this.area.append("Fin del reporte");
    }
    
    public void AFT (){
        this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
        for(Palabra p: palabras){
            p.MostrarPalabra(area);
            area.append(":\n");
            p.ReporteTransicion(area);
            area.append("Por eso ");
            p.MostrarMensajeToken(area);
            this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
            
        }
        
        this.area.append("Fin del reporte");
    }
    
}
