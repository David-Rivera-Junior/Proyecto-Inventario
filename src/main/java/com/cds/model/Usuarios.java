package com.cds.model;
// Generated 07-06-2019 08:35:56 AM by Hibernate Tools 0.0.1-SNAPSHOT

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios", catalog = "inventario")
public class Usuarios implements java.io.Serializable {

	private Long idUsuario;
	private Roles roles;
	private String nombre ;
	private String apellido ;
	private String dui ;
	private String direccion ;
	private String telefono ;
	private String usuario;
	private String pass;
	
	public Usuarios() {
	}

	public Usuarios(Long idUsuario, Roles roles, String nombre, String apellido, String dui, String direccion,
			String telefono, Date fechaRegistro, Date fechaModificacion, String usuario, String pass) {
		super();
		this.idUsuario = idUsuario;
		this.roles = roles;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dui = dui;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.pass = pass;
	}

	public Usuarios(long idUsuario, String nombre, String apellido, String dui, String direccion,
			String telefono, String usuario, String contraseņa, Roles rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dui = dui;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.pass = contraseņa;
		this.roles = rol;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_usuario")
	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_rol")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido")
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "dui")
	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "usuario")
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "pass")
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
