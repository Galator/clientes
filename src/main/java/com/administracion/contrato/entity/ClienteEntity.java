package com.administracion.contrato.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.administracion.contrato.model.ClientModel;

@Entity
@Table(name="cliente")
public class ClienteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="nombre_razon_social")
	private String nombreRazonSocial;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Column(name="fecha_nacimiento_creacion")
	private LocalDate fechaNacimientoCreacion;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="tipo_cliente")
	private String tipoCliente;
	
	@OneToMany(mappedBy = "cliente", fetch=FetchType.LAZY)
	private List<ContratoEntity> contratos = new ArrayList<>();

	public ClienteEntity () {}
	
	public ClienteEntity (ClientModel model) {
		this.rfc = model.getRfc();
		this.nombreRazonSocial = model.getName();
		this.apellidoPaterno = model.getLastName();
		this.apellidoMaterno = model.getMotherSurname();
		this.fechaNacimientoCreacion = model.getClientDate();
		this.direccion = model.getAddress();
		this.tipoCliente = model.getClientType();
	}
	
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public LocalDate getFechaNacimientoCreacion() {
		return fechaNacimientoCreacion;
	}

	public void setFechaNacimientoCreacion(LocalDate fechaNacimientoCreacion) {
		this.fechaNacimientoCreacion = fechaNacimientoCreacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<ContratoEntity> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoEntity> contratos) {
		this.contratos = contratos;
	}

}
