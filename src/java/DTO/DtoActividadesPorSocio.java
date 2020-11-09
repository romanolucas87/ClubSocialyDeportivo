/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Modelo.Actividad;
import Modelo.Socio;

/**
 *
 * @author Lucas
 */
public class DtoActividadesPorSocio {
    private String nombreSocio;
    private String nombreActividad;
    private int idSocio;
    private int idActividad;
    private boolean estadoInscripcion;

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public boolean isEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(boolean estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public DtoActividadesPorSocio(String nombreSocio, String nombreActividad, int idSocio, int idActividad, boolean estadoInscripcion) {
        this.nombreSocio = nombreSocio;
        this.nombreActividad = nombreActividad;
        this.idSocio = idSocio;
        this.idActividad = idActividad;
        this.estadoInscripcion = estadoInscripcion;
    }

    public DtoActividadesPorSocio(String nombreSocio, String nombreActividad, int idSocio, int idActividad) {
        this.nombreSocio = nombreSocio;
        this.nombreActividad = nombreActividad;
        this.idSocio = idSocio;
        this.idActividad = idActividad;
    }

    

    public DtoActividadesPorSocio() {
    }

 
    
    
    
}
