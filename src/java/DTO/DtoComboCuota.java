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
public class DtoComboCuota {
    
 public int idCuota;
public String nroCuota;

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public String getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(String nroCuota) {
        this.nroCuota = nroCuota;
    }

    public DtoComboCuota(int idCuota, String nroCuota) {
        this.idCuota = idCuota;
        this.nroCuota = nroCuota;
    }

    public DtoComboCuota(String nroCuota) {
        this.nroCuota = nroCuota;
    }

    public DtoComboCuota() {
    }

    
    

    
}
