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
public class Actividad {

    private int idActividad;
    private String nombreActividad;
    private double precioActividad;
    private boolean estadoActividad;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public double getPrecioActividad() {
        return precioActividad;
    }

    public void setPrecioActividad(double precioActividad) {
        this.precioActividad = precioActividad;
    }

    public boolean isEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(boolean estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

//    CONSTRUCTOR SIN ID
    public Actividad(String nombreActividad, double precioActividad, boolean estadoActividad) {
        
        this.nombreActividad = nombreActividad;
        this.precioActividad = precioActividad;
        this.estadoActividad = estadoActividad;
    }
//    CONSTRUCTOR CON ID
    public Actividad(int idActividad, String nombreActividad, double precioActividad, boolean estadoActividad) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.precioActividad = precioActividad;
        this.estadoActividad = estadoActividad;
    }

    public Actividad() {
    }
    
    

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", nombreActividad=" + nombreActividad + ", precioActividad=" + precioActividad + '}';
    }
    
    
    
    

}
