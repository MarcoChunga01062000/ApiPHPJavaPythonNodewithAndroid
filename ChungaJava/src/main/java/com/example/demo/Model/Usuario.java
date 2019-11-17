package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private Long idusuario;
	
	@Column(name="name")
	private String name;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="origen")
	private String origen;
	
	public Usuario() {
		
	}
	
	public Usuario(Long idusuario, String name, String correo, String pass, String origen) {
		this.idusuario = idusuario;
		this.name = name;
		this.correo = correo;
		this.pass = pass;
		this.origen = origen;
	}

	public Usuario(String name, String correo, String pass, String origen) {
		this.name = name;
		this.correo = correo;
		this.pass = pass;
		this.origen = origen;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", name=" + name + ", correo=" + correo + ", pass=" + pass
				+ ", origen=" + origen + "]";
	}
	
}
