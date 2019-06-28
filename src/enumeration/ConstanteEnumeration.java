/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.enumeration;

/**
 *
 * @author Miguel Tenezaca
 */
public enum ConstanteEnumeration {

    UTF8("UTF-8"),
    SECRETKEY("7hokf&$j7xiqvq%*!_3@!7wpxj+yPoEl");
    private String tipo;

    ConstanteEnumeration(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
