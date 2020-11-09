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
public class DtoListaSocios {
    private int idSocio;
    private String nombreSocio;
    private String apellidoSocio;
    private long telefono;
    private String direccion;
    private String fechaNacimiento;
    private String nacionalidad;
    private String tipoDocumento;
    private int nroDocumento;
    private String email;

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

    public String getApellidoSocio() {
        return apellidoSocio;
    }

    public void setApellidoSocio(String apellidoSocio) {
        this.apellidoSocio = apellidoSocio;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DtoListaSocios(int idSocio, String nombreSocio, String apellidoSocio, long telefono, String direccion, String fechaNacimiento, String nacionalidad, String tipoDocumento, int nroDocumento, String email) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
        this.apellidoSocio = apellidoSocio;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.email = email;
    }

    @Override
    public String toString() {
        return "DtoListaSocios{" + "idSocio=" + idSocio + ", nombreSocio=" + nombreSocio + ", apellidoSocio=" + apellidoSocio + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + ", tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", email=" + email + '}';
    }

    
    
    
    
    
    
}
