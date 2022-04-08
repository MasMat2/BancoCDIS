package com.bancocdis.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{

	private static final long serialVersionUID = -8368608044018073920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty
	private String nombre;
	
	@Column
	@NotEmpty
	private String apellido;
	
	@Column
	@NotEmpty
	private String puesto;
	
	@Column(name = "dia_ingreso")
	@NonNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date diaIngreso;
	
	@JoinColumn(name = "banco", referencedColumnName = "id", nullable = false)
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Banco banco;
	

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Date getDiaIngreso() {
		return diaIngreso;
	}

	public void setDiaIngreso(Date diaIngreso) {
		this.diaIngreso = diaIngreso;
	}
	
	
}
