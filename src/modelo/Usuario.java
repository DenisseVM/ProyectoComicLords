/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author denisse
 */
public class Usuario {
    
    int idUsuario;
    String usuario, contrasenna;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String contrasenna) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

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

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrasenna=" + contrasenna + '}';
    }
    
}
