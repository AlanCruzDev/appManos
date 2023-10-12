package com.app.Usuario.Dto;

import java.util.Date;
import java.util.List;

public class UsuarioDTO {
	
	private Long Id;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
    private int edad;
    private Date fechaNaciento;
    private int intentos;
    private String nombreUsuario;
    private List<RolesDTO> rolesdto;
    
    
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
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public List<RolesDTO> getRolesdto() {
		return rolesdto;
	}
	public void setRolesdto(List<RolesDTO> rolesdto) {
		this.rolesdto = rolesdto;
	}
    
}
