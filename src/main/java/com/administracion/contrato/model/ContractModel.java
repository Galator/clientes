package com.administracion.contrato.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.administracion.contrato.entity.ContratoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ContractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer contractNumber;

	private LocalDate contractDate;
	
	@JsonInclude(Include.NON_NULL)
	private ClientModel client;
	
	@JsonInclude(Include.NON_NULL)
	private List<AnnexModel> annexList = new ArrayList<>();
	
	public ContractModel () {}
	
	public ContractModel (ContratoEntity entity) {
		this.contractNumber = entity.getNumeroContrato();
		this.contractDate = entity.getFechaContrato();
		
		if (!entity.getAnexos().isEmpty()) {
			entity.getAnexos().forEach(annex -> annexList.add(new AnnexModel(annex)));
		}
	}

	public Integer getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Integer contractNumber) {
		this.contractNumber = contractNumber;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	public List<AnnexModel> getAnnexList() {
		return annexList;
	}

	public void setAnnexList(List<AnnexModel> annexList) {
		this.annexList = annexList;
	}

}
