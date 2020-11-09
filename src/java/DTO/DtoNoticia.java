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
public class DtoNoticia {
    
     private int idNoticia;
    private String actividad;
    private String descripcionNoticia;
    private boolean estadoNoticia;

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcionNoticia() {
        return descripcionNoticia;
    }

    public void setDescripcionNoticia(String descripcionNoticia) {
        this.descripcionNoticia = descripcionNoticia;
    }

    public boolean isEstadoNoticia() {
        return estadoNoticia;
    }

    public void setEstadoNoticia(boolean estadoNoticia) {
        this.estadoNoticia = estadoNoticia;
    }
    
    
    
    
}
