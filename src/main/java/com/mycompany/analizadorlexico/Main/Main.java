/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Main;
import com.mycompany.analizadorlexico.Frames.Principal;
import java.util.*;

/**
 *
 * @author manu
 */
public class Main {
    String palabra;
    int posicion = 0;
    int matriz[][] = new int[4][2];
    int estadosFinalizacion[] = new int[2];
    String descripcionFinalizacion[] = new String[2];
    int estadoActual = 0;

    // filas s1 --> 1 s2 -> 2
    // \digito --> 1
    // . --> 2
    // no pertenece a mi alfabeto -1
    {
        matriz[0][0] = 1;
        matriz[0][1] = -1;
        matriz[1][0] = 1;
        matriz[1][1] = 2;
        matriz[2][0] = 3;
        matriz[2][1] = -1;
        matriz[3][0] = 3;
        matriz[3][1] = -1;

        //numero entero
        estadosFinalizacion[0]=1;
        descripcionFinalizacion[0]="Numero entero";
        //numero flotante
        estadosFinalizacion[1]=3;
        descripcionFinalizacion[1]="Numero double";
    }

    public static void main(String[] args) {
        Principal ventana = new Principal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

    public Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la palabra: ");
        palabra = scanner.nextLine();

        while (posicion < palabra.length()) 
            getToken();
        /*
         * for (char caracter : palabra.toCharArray()) { System.out.println(caracter); }
         */

        scanner.close();
    }

    //revisa movimiento den la matriz
    public int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 1) {
            resultado = matriz[estadoActual][caracter];
        }
        return resultado;
    }


    //alfabeto
    public int getIntCaracter(char caracter) {
        int resultado = -1;

        if (Character.isDigit(caracter)) {
            resultado = 0;
        } else {
            if (caracter == '.')
                resultado = 1;
        }

        return resultado;
    }

    public String getEstadoAceptacion(int i){
        String res = "Error";
        int indice = 0;
        for (int estadoAceptacion : estadosFinalizacion) {
            
            if (estadoAceptacion == i){
                res = descripcionFinalizacion[indice];
                break;
            }
            indice++;
        }

        return res;
    }

    public void getToken() {
        estadoActual = 0;
        boolean seguirLeyendo = true;
        char tmp;
        String token = "";

        while ((seguirLeyendo) && (posicion < palabra.length())) {
            if (Character.isSpaceChar(tmp = palabra.charAt(posicion))) {
                seguirLeyendo = false;
            } else {
                // para mi automata
                int estadoTemporal = getSiguienteEstado(estadoActual, getIntCaracter(tmp));
                System.out.println("Estado actual " + estadoActual + " caracter "+ tmp + " transicion a "+estadoTemporal);
                token+=tmp;
                estadoActual = estadoTemporal;

                System.out.println(tmp);
            }
            posicion++;
        }
        System.out.println("*********Termino en el estado "+ getEstadoAceptacion(estadoActual) + " token actual : "+token);
        // verificar el estado de aceptación

    }
    
    
}
