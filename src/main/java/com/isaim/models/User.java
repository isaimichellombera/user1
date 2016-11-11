package com.isaim.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tc_cliente")
public class User {

	// database fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String nombre;

	@NotNull
	private String apellido_materno;

	@NotNull
	private String apellido_paterno;

	// public methods
	
	public User() {}

	public User(long id) {
		this.id = id;
	}

	public User(String nombre, String apellido_materno, String apellido_paterno) {
		this.nombre = nombre;
		this.apellido_materno = apellido_materno;
		this.apellido_paterno = apellido_paterno;
	}

	// getter setter methods
	
	public long getId() {
		return id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public String getApellidoMaterno() {
		return apellido_materno;
	}

	public void setApellidoMaterno(String value) {
		this.apellido_materno = value;
	}

	public String getApellidoPaterno() {
		return apellido_paterno;
	}

	public void setApellidoPaterno(String value) {
		this.apellido_paterno = value;
	}
}
