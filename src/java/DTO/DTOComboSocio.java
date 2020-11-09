/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Lucas
 */
public class DTOComboSocio {
    private int idSocio;
    private String nombreSocio;

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public DTOComboSocio(int idSocio, String nombreSocio) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
    }
    
    
}
