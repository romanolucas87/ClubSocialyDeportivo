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
public class DtoComboNacionalidad {
    
private int idNacionalidad;
private String descripcionNacionalidad;

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getDescripcionNacionalidad() {
        return descripcionNacionalidad;
    }

    public void setDescripcionNacionalidad(String descripcionNacionalidad) {
        this.descripcionNacionalidad = descripcionNacionalidad;
    }

    public DtoComboNacionalidad(int idNacionalidad, String descripcionNacionalidad) {
        this.idNacionalidad = idNacionalidad;
        this.descripcionNacionalidad = descripcionNacionalidad;
    }

    @Override
    public String toString() {
        return  idNacionalidad + "- " + descripcionNacionalidad ;
    }



    
    
}
