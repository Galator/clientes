package com.administracion.contrato.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class ContratoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_contrato")
	private Integer numeroContrato;

	@Column(name = "fecha_contrato")
	private LocalDate fechaContrato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rfc_cliente")
	private ClienteEntity cliente; 
	
	@OneToMany(mappedBy = "contrato", fetch = FetchType.LAZY)
	private List<AnexoEntity> anexos = new ArrayList<>();

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public LocalDate getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public List<AnexoEntity> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<AnexoEntity> anexos) {
		this.anexos = anexos;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
}
