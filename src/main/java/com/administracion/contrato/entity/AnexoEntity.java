package com.administracion.contrato.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="anexo")
public class AnexoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="numero_anexo")
	private Integer numeroAnexo;
	
	@Column(name="plazo")
	private Integer plazo;
	
	@Column(name="pago_mensual")
	private Double pagoMensual;
	
	@Column(name="numero_serie")
	private String numeroSerie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="numero_contrato")
	private ContratoEntity contrato;

	public Integer getNumeroAnexo() {
		return numeroAnexo;
	}

	public void setNumeroAnexo(Integer numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Double getPagoMensual() {
		return pagoMensual;
	}

	public void setPagoMensual(Double pagoMensual) {
		this.pagoMensual = pagoMensual;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public ContratoEntity getContrato() {
		return contrato;
	}

	public void setContrato(ContratoEntity contrato) {
		this.contrato = contrato;
	}

}
