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
public class DTONoticiaFiltrada {
    
    private String actividad;
    private String noticia;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public DTONoticiaFiltrada(String actividad, String noticia) {
        this.actividad = actividad;
        this.noticia = noticia;
    }
    
    
    
}
