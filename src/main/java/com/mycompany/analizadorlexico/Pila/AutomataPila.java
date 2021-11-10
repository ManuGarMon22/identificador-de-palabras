/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizadorlexico.Pila;

import com.mycompany.analizadorlexico.Enums.TipoToken;
import com.mycompany.analizadorlexico.Modelos.Palabra;
import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 *
 * @author manu
 * 
 * para entender del todo el funcionamiento del automata de pila necesitaremos apoyarnos en el trabajo teorico-practico
 */
public class AutomataPila {
    
    private Pila pila = new Pila();
    

    int palabraActual = 0;
    int error =  0;
 
    // donde cada estado representa letra para la trancision en la gramatica
    
    private ArrayList<Palabra> palabras;
    private ArrayList<Palabra> errores = new ArrayList<Palabra>();
    private boolean aceptacion = false;
    
    private TipoToken[] opcionToken = new TipoToken[18]; 
    {
    opcionToken[0] = TipoToken.R_ESCRIBIR;    opcionToken[1] = TipoToken.R_REPETIR;
    opcionToken[2] = TipoToken.R_SI;          opcionToken[3] = TipoToken.R_ENTONCES;
    opcionToken[4] = TipoToken.R_INICIAR;     opcionToken[5] = TipoToken.R_VERDADERO;
    opcionToken[6] = TipoToken.R_FALSO;       opcionToken[7] = TipoToken.R_FIN;
    opcionToken[8] = TipoToken.POSITIVO;      opcionToken[9] = TipoToken.NEGATIVO;
    opcionToken[10] = TipoToken.IDENTIFICADOR;opcionToken[11] = TipoToken.LITERAL;
    opcionToken[12] = TipoToken.PA;           opcionToken[13] = TipoToken.PC;
    opcionToken[14] = TipoToken.SUMA;         opcionToken[15] = TipoToken.MULTI;
    opcionToken[16] = TipoToken.IGUAL;        opcionToken[17] = TipoToken.ACEPTACION;
    }
    
    public AutomataPila( ArrayList<Palabra> palabras){
        this.palabras = palabras;
        this.AceptacionLexico();
    }
    
    
    
    
    public void transicion(JTextArea r){
        
        
        this.pila.Insertar(100);
        this.pila.Insertar(0);
        TipoToken x;        
        
        do{
        x = palabras.get(palabraActual).getToken();
            this.accionEstado(x);
    
        }while(!this.pila.PilaVacia());
        
        r.append("Lectura de gramatica completada \n");
        
        if(error != 0){
            r.append("Hay "+error+" errores en la gramatica\n" );
            this.ErroresGramatica(r);
        }else {
            r.append("Archivo sin errores gramaticos \n");
        }
                    
                
    }
    
    private void ErroresGramatica(JTextArea r){
        int i = 1;
        for(Palabra p: this.errores){
            r.append(i+") ");
            p.MostrarPalabra(r);
            r.append(p.getPosicion()+"\n");
            i++;
        }
    }
    // agragamos nuestro simbolo de finalizacion de evaluacion de gramatica a 
    // nuestra lista de palabras para saber en que mento se deja de evaluar 
    private void AceptacionLexico(){
        Palabra nueva = new Palabra();
        nueva.setToken(TipoToken.ACEPTACION);
        nueva.addLetter('$');
        this.palabras.add(nueva);
    }
    
    private void accionEstado(TipoToken x){
            
        if(this.pila.getUltimoValorIngresado() < 0){
            this.errores.add(this.palabras.get(palabraActual));
            do{
               this.pila.EliminarNodo();
            }while(this.pila.getUltimoValorIngresado()!=1);
            error++;
            palabraActual++;
            
            
        }else{    
            if(x == this.opcionToken[0]){//TOKEN ESCRIBIR
                switch (this.pila.getUltimoValorIngresado()){
                    case 0:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        break;
                    case 1:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        this.pila.Insertar(2);
                        break;
                    case 2:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(3);
                        break;
                    case 3:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(6);
                        this.pila.Insertar(4);
                        break;
                    case 4:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(31);
                        this.pila.Insertar(5);
                        break;
                    case 5:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    case 13:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(13);
                        this.pila.Insertar(3);
                        break;
                        
                    case 21:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(3);
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
                  
            }else if(x == this.opcionToken[1]){//TOKEN REPETIR
                switch (this.pila.getUltimoValorIngresado()){
                    case 0:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        break;
                    case 1:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        this.pila.Insertar(2);
                        break;
                    case 2:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(7);
                        break;
                    case 7:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(6);
                        this.pila.Insertar(8);
                        break;
                    case 8:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(10);
                        this.pila.Insertar(9);
                        break;
                    case 9:    
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
            
            }else if(x == this.opcionToken[2]){// TOKEN SI
                switch (this.pila.getUltimoValorIngresado()){
                    case 0:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        break;
                    case 1:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        this.pila.Insertar(2);
                        break;
                    case 2:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(14);
                        break;
                    case 14:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(6);
                        this.pila.Insertar(15);
                        break;
                    case 15:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(17);
                        this.pila.Insertar(16);
                        break;
                    case 16:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default: this.pila.Insertar(-1);
                    
                }        
            }else if(x == this.opcionToken[3]){//TOKEN ENTONCES
                switch (this.pila.getUltimoValorIngresado()){
                    case 19:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(21);
                        this.pila.Insertar(20);
                        break;
                    case 20:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default: this.pila.Insertar(-1);
                }
            
            }else if(x == this.opcionToken[4]){//TOKEN INICIO
                switch (this.pila.getUltimoValorIngresado()){
                    case 11:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(13);
                        this.pila.Insertar(12);
                        break;
                    case 12:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default: this.pila.Insertar(-1);
                }
            
            }else if(x == this.opcionToken[5]||x == this.opcionToken[6]){//TOKEN VER/FAL
                switch (this.pila.getUltimoValorIngresado()){
                    case 17:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(19);
                        this.pila.Insertar(18);
                        break;
                    case 18:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default: this.pila.Insertar(-1);
                }
                if(x == this.opcionToken[5]){
                    
                }
                
            }else if(x == this.opcionToken[7]){ // TOKEN FIN
                switch(this.pila.getUltimoValorIngresado()){
                    case 6:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    case 13:
                        this.pila.EliminarNodo();
                        break;
                    case 21:
                        this.pila.EliminarNodo();
                        break;
                    case 23:    
                        this.pila.EliminarNodo();
                        break;
                    case 25:    
                        this.pila.EliminarNodo();
                        break;  
                    default:
                        this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[8]||x == this.opcionToken[9]){// token numero
                switch (this.pila.getUltimoValorIngresado()){
                    case 10:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(11);
                        this.pila.Insertar(32);
                        break;
                    case 22:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(23);
                        this.pila.Insertar(24);
                        break;                    
                    case 24:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(25);
                        this.pila.Insertar(26);
                        break;                 
                    case 26:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(32);
                        break;  
                    case 31:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(32);
                        break;
                    case 32:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
                        
            }else if(x == this.opcionToken[10]){// token ID
                switch (this.pila.getUltimoValorIngresado()){
                    case 0:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        break;
                    case 1:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(1);
                        this.pila.Insertar(2);
                        break;
                    case 2:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(27);
                        break;
                    case 10:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(11);
                        this.pila.Insertar(32);
                        break;
                    case 22:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(23);
                        this.pila.Insertar(24);
                        break;
                    case 24:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(25);
                        this.pila.Insertar(26);
                        break;                   
                    case 26:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(32);
                        break;                   
                    case 27:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(6);
                        this.pila.Insertar(28);
                        break;                   
                    case 28:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(29);
                        this.pila.Insertar(33);
                        break;
                    case 31:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(32);
                        break;    
                    case 32:    
                        this.pila.EliminarNodo();
                        this.pila.Insertar(33);
                        break;
                    case 33:    
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[11]){// token lit
                if(this.pila.getUltimoValorIngresado() == 31){
                    this.pila.EliminarNodo();
                    palabraActual++;
                }else{
                    this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[12]){// token parentesis apertura 
                switch(this.pila.getUltimoValorIngresado()){
                    case 22:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(23);
                        this.pila.Insertar(24);
                        break;
                    case 24:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(25);
                        this.pila.Insertar(26);
                        break;                    
                    case 26:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(112);
                        this.pila.Insertar(22);
                        palabraActual++;
                        break;    
                    default:
                        this.pila.Insertar(-1);                        
                }
                
            }else if(x == this.opcionToken[13]){//token parentesis cierre
                switch(this.pila.getUltimoValorIngresado()){
                    case 23:
                        this.pila.EliminarNodo();
                        break;
                    case 25:
                        this.pila.EliminarNodo();
                        break;
                    case 112:
                        this.pila.EliminarNodo();
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
            
            }else if(x == this.opcionToken[14]){//token suma
                switch(this.pila.getUltimoValorIngresado()){
                    case 23:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(23);
                        this.pila.Insertar(24);
                        palabraActual++;
                        break;          
                    case 25:
                        this.pila.EliminarNodo();
                        break;
                    default:
                        this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[15]){//token multi
                if(this.pila.getUltimoValorIngresado()==25){
                    this.pila.EliminarNodo();
                    this.pila.Insertar(25);
                    this.pila.Insertar(26);
                    palabraActual++;
                }else{
                    this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[16]){//token igual
                switch (this.pila.getUltimoValorIngresado()){
                    case 29:
                        this.pila.EliminarNodo();
                        this.pila.Insertar(22);
                        this.pila.Insertar(30);
                        break;
                    case 30:
                        this.pila.EliminarNodo();
                        palabraActual++;
                        break;
                    default: this.pila.Insertar(-1);
                }
            }else if(x == this.opcionToken[17]){//token aceptacion
                this.pila.EliminarNodo();
            }else if(x == TipoToken.COMENTARIO){
                palabraActual++;
            }
        }
    }

    public boolean isAceptacion() {
        return aceptacion;
    }
    
    
}
