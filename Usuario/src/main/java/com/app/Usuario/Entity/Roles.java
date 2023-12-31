package com.app.Usuario.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_sequence_generator")
	@SequenceGenerator(name = "roles_sequence_generator", sequenceName = "roles_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(unique = true, length = 30)
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
