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
public class DtoTipoDocumento {

    private int idTipoDocumento;
    private String descripcionDocumento;

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }

    public DtoTipoDocumento(int idTipoDocumento, String descripcionDocumento) {
        this.idTipoDocumento = idTipoDocumento;
        this.descripcionDocumento = descripcionDocumento;
    }

    @Override
    public String toString() {
        return descripcionDocumento;
    }
    
    

}
