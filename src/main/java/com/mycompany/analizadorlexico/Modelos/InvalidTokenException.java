/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.Modelos;

/**
 *
 * @author manu
 */
public class InvalidTokenException extends Exception {

    public InvalidTokenException() {
    }
    
    public InvalidTokenException(String message) {
        super(message);
    }
    
}
