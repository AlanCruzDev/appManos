package com.app.Usuario.Entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence_generator")
	    @SequenceGenerator(name = "usuario_sequence_generator", sequenceName = "usuario_sequence", allocationSize = 1)
	    @Column(name = "id")
    private Long Id;
	
	
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apelliod_paterno")
    private String apellidoP;

    @Column(name = "apellido_materno")
    private String apellidoM;

    @Column(name = "edad")
    private int edad;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNaciento;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "contrasenia_usuario")
    private String contrasenia;

    @Column(name = "status_cliente")
    private boolean statusCliente;

    @Column(name = "intentos")
    private int intentos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="usuarios_roles",joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name="role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id","role_id"})})
    private List<Roles> roles;

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

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
