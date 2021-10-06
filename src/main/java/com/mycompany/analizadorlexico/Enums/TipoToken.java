/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Enums;

/**
 *
 * @author manu
 */
public enum TipoToken {
    
    IDENTIFICADOR("Es un dentificador"),
    ENTERO("Es un numero entero"),
    DECIMAL("Es un numero decimal"),
    PUNTUACION("Es un signo de puntuacion"),
    OPERADOR("Es un signo Aritmetico"),
    AGRUPACION("Es un signo de agruoacion"),
    ERROR("Es un error, no es un token valido");
    
    private String mensaje;
    
    TipoToken(String e){
        this.mensaje = e;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
}
