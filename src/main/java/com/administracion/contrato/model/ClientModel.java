package com.administracion.contrato.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.administracion.contrato.entity.ClienteEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ClientModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@Size(max = 13)
	private String rfc;

	@NotNull
	@NotEmpty
	@Size(max = 100)
	private String name;

	@JsonInclude(Include.NON_NULL)
	private String lastName;

	@JsonInclude(Include.NON_NULL)
	private String motherSurname;

	private LocalDate clientDate;

	@NotNull
	@NotEmpty
	@Size(max = 100)
	private String address;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "FISICA | MORAL")
	private String clientType;
	
	@JsonInclude(Include.NON_NULL)
	private String customerAge;

	@JsonInclude(Include.NON_NULL)
	private List<ContractModel> contracts = new ArrayList<>();

	public ClientModel() {
	}

	public ClientModel(ClienteEntity entity) {
		this.rfc = entity.getRfc();
		this.name = entity.getNombreRazonSocial();
		this.lastName = entity.getApellidoPaterno();
		this.motherSurname = entity.getApellidoMaterno();
		this.clientDate = entity.getFechaNacimientoCreacion();
		this.address = entity.getDireccion();
		this.clientType = entity.getTipoCliente();

		if (!entity.getContratos().isEmpty()) {
			entity.getContratos().forEach(contract -> this.contracts.add(new ContractModel(contract)));
		}

	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherSurname() {
		return motherSurname;
	}

	public void setMotherSurname(String motherSurname) {
		this.motherSurname = motherSurname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public LocalDate getClientDate() {
		return clientDate;
	}

	public void setClientDate(LocalDate clientDate) {
		this.clientDate = clientDate;
	}

	public List<ContractModel> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContractModel> contracts) {
		this.contracts = contracts;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

}
