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
public class Pago {
 private int idPago;
private int idCuota;
private int idSocio;
private float monto;
private String fechaPago;
private String fechaVencimiento;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Pago(int idPago, int idCuota, int idSocio, float monto, String fechaPago, String fechaVencimiento) {
        this.idPago = idPago;
        this.idCuota = idCuota;
        this.idSocio = idSocio;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Pago(int idCuota, int idSocio, float monto, String fechaPago, String fechaVencimiento) {
        this.idCuota = idCuota;
        this.idSocio = idSocio;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
    }





}
