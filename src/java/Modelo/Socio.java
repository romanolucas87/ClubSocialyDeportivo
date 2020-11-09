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
public class Socio {

    private int idSocio;
    private String nombreSocio;
    private String apellidoSocio;
    private long telefonoSocio;
    private String direccionSocio;
    private String fechaNacimiento;
    private int idNacionalidad;
    private int tipoDocumento;
    private int documentoSocio;
    private String email;
    private boolean estadoSocio;

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

    public long getTelefonoSocio() {
        return telefonoSocio;
    }

    public void setTelefonoSocio(int telefonoSocio) {
        this.telefonoSocio = telefonoSocio;
    }

    public String getDireccionSocio() {
        return direccionSocio;
    }

    public void setDireccionSocio(String direccionSocio) {
        this.direccionSocio = direccionSocio;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDocumentoSocio() {
        return documentoSocio;
    }

    public void setDocumentoSocio(int documentoSocio) {
        this.documentoSocio = documentoSocio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstadoSocio() {
        return estadoSocio;
    }

    public void setEstadoSocio(boolean estadoSocio) {
        this.estadoSocio = estadoSocio;
    }

    public Socio(int idSocio, String nombreSocio, String apellidoSocio, long telefonoSocio, String direccionSocio, String fechaNacimiento, int idNacionalidad, int tipoDocumento, int documentoSocio, String email, boolean estadoSocio) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
        this.apellidoSocio = apellidoSocio;
        this.telefonoSocio = telefonoSocio;
        this.direccionSocio = direccionSocio;
        this.fechaNacimiento = fechaNacimiento;
        this.idNacionalidad = idNacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.documentoSocio = documentoSocio;
        this.email = email;
        this.estadoSocio = estadoSocio;
    }
//CONSTRUCTOR SIN ID
    public Socio(String nombreSocio, String apellidoSocio, long telefonoSocio, String direccionSocio, String fechaNacimiento, int idNacionalidad, int tipoDocumento, int documentoSocio, String email, boolean estadoSocio) {
        this.nombreSocio = nombreSocio;
        this.apellidoSocio = apellidoSocio;
        this.telefonoSocio = telefonoSocio;
        this.direccionSocio = direccionSocio;
        this.fechaNacimiento = fechaNacimiento;
        this.idNacionalidad = idNacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.documentoSocio = documentoSocio;
        this.email = email;
        this.estadoSocio = estadoSocio;
    }

    public Socio() {
    }
    
    

    @Override
    public String toString() {
        return "Socio{" + "idSocio=" + idSocio + ", nombreSocio=" + nombreSocio + ", apellidoSocio=" + apellidoSocio + ", telefonoSocio=" + telefonoSocio + ", direccionSocio=" + direccionSocio + ", fechaNacimiento=" + fechaNacimiento + ", idNacionalidad=" + idNacionalidad + ", tipoDocumento=" + tipoDocumento + ", documentoSocio=" + documentoSocio + ", email=" + email + ", estadoSocio=" + estadoSocio + '}';
    }

    
    

}
