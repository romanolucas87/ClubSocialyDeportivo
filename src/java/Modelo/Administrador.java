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
public class Administrador {

    private int idUsuario;
    private String usuario;
    private String password;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrador(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public Administrador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    
    

}
