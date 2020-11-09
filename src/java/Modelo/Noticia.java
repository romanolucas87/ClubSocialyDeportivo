/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lucas
 */
public class Noticia {

    private int idNoticia;
    private Actividad idActividad;
    private String descripcionNoticia;
    private boolean estadoNoticia;

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
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

     
    public Noticia(int idNoticia, Actividad idActividad, String descripcionNoticia, boolean estadoNoticia) {
        this.idNoticia = idNoticia;
        this.idActividad = idActividad;
        this.descripcionNoticia = descripcionNoticia;
        this.estadoNoticia = estadoNoticia;
    }
//CONSTRUCTOR SIN ID
    public Noticia(Actividad idActividad, String descripcionNoticia, boolean estadoNoticia) {
        this.idActividad = idActividad;
        this.descripcionNoticia = descripcionNoticia;
        this.estadoNoticia = estadoNoticia;
    }

    public Noticia() {
    }

    
    
    

    @Override
    public String toString() {
        return "Noticia{" + "idNoticia=" + idNoticia + ", idActividad=" + idActividad + ", descripcionNoticia=" + descripcionNoticia + '}';
    }
    
    
    
    

}
