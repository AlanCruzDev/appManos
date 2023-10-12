package com.app.Oauth.Modelos;

import java.util.Date;
import java.util.List;

public class Usuario {
    private Long Id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private Date fechaNaciento;
    private String nombreUsuario;
    private String contrasenia;
    private boolean statusCliente;
    private List<Rol> roles;
    private Integer intentos;

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Date getFechaNaciento() {
        return fechaNaciento;
    }
    public void setFechaNaciento(Date fechaNaciento) {
        this.fechaNaciento = fechaNaciento;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public boolean isStatusCliente() {
        return statusCliente;
    }
    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
