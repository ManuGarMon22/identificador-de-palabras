/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Manejadores;

import com.mycompany.analizadorlexico.Enums.TipoToken;
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
            if(p != null){
            p.ReportePalabra(area);
            this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
            }
        }
        this.area.append("Fin del reporte");
    }
    
    public void AFT (){
        if(palabras.size()>0){
        this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
        for(Palabra p: palabras){
            if(p!=null){
            p.MostrarPalabra(area);
            area.append(":\n");
            p.ReporteTransicion(area);
            area.append("Por eso ");
            p.MostrarMensajeToken(area);
            this.area.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
            }
        }
        }
        
        this.area.append("Fin del reporte");
    }
    
    public void Listado(){
        if(palabras.size()>0){
            int contador=1;
            area.append("-----------------------------------------------------------Identificadores------------------------------------------------------------\n");
            for(Palabra r: palabras){
                if(r!= null){
                    if(r.getToken() == TipoToken.IDENTIFICADOR){
                        area.append(contador+") ");
                        r.MostrarPalabra(area);
                        area.append("\n");
                        contador++;
                    }
                }
            }
            contador = 1;
            area.append("---------------------------------------------------------Numeros Enteros----------------------------------------------------------\n");
            for(Palabra r: palabras){
                if(r!= null){
                    if(r.getToken() == TipoToken.NEGATIVO || r.getToken() == TipoToken.POSITIVO ){
                        area.append(contador+") ");
                        r.MostrarPalabra(area);
                        area.append("\n");
                        contador++;
                    }
                }
            }
            contador = 1;
            
            area.append("------------------------------------------------------comentarios------------------------------------------------------\n");
            for(Palabra r: palabras){
                if(r!= null){
                    if(r.getToken() == TipoToken.COMENTARIO){
                        area.append(contador+") ");
                        r.MostrarPalabra(area);
                        area.append("\n");
                        contador++;
                    }
                }
            }
            contador = 1;
            area.append("--------------------------------------------------------literales---------------------------------------------------------\n");
            for(Palabra r: palabras){
                if(r!= null){
                    if(r.getToken() == TipoToken.LITERAL){
                        area.append(contador+") ");
                        r.MostrarPalabra(area);
                        area.append("\n");
                        contador++;
                    }
                }
            }
            contador = 1;
          
            
            area.append("-----------------------------------------------------------FIN DEL REPORTE---------------------------------------------------------");
        }
    }
    
    public static void Errores(ArrayList<Palabra> pa, JTextArea areaReporte){
        for(Palabra r: pa){
                if(r!= null){
                    if(r.getToken() == TipoToken.ERROR){
                        //area.append(" ");
                        r.MostrarPalabra(areaReporte);
                        areaReporte.append("\n");
                        
                    }
                }
            }
            
    }
    
}
