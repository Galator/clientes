package com.administracion.contrato.model;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.administracion.contrato.entity.AnexoEntity;
import com.administracion.contrato.entity.ContratoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AnnexModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer annexNumber;

	@Digits(integer=3, fraction=0)
	private Integer period;

	@Digits(integer=6, fraction=2)
	private Double monthlyPayments;

	@NotNull
	@NotEmpty
	private String serialNumber;

	@JsonInclude(Include.NON_NULL)
	private ContratoEntity contract;
	
	public AnnexModel () {}
	
	public AnnexModel (AnexoEntity entity) {
		this.annexNumber = entity.getNumeroAnexo();
		this.period = entity.getPlazo();
		this.monthlyPayments = entity.getPagoMensual();
		this.serialNumber = entity.getNumeroSerie();
	}

	public Integer getAnnexNumber() {
		return annexNumber;
	}

	public void setAnnexNumber(Integer annexNumber) {
		this.annexNumber = annexNumber;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Double getMonthlyPayments() {
		return monthlyPayments;
	}

	public void setMonthlyPayments(Double monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public ContratoEntity getContract() {
		return contract;
	}

	public void setContract(ContratoEntity contract) {
		this.contract = contract;
	}

}
