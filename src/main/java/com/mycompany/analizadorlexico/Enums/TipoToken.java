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
    NEGATIVO("Es un numero entero negativo"),
    POSITIVO("Es un numero entero positivo"),
   
    ERROR("Es un error, no es un token valido"),
    
    COMENTARIO("Es un comentario"),
    LITERAL("Es un literal"),
    
    R_SI("es una palabra reservada"),
    R_FIN("es una palabra reservada"),
    R_FALSO("es una palabra reservada"),
    R_REPETIR("es una palabra reservada"),
    R_INICIAR("es una palabra reservada"),
    R_ENTONCES("es una palabra reservada"),
    R_ESCRIBIR("es una palabra reservada"),
    R_VERDADERO("es una palabra reservada");
    
    private String mensaje;
    
    TipoToken(String e){
        this.mensaje = e;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
}
