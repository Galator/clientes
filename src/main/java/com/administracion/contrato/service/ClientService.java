package com.administracion.contrato.service;

import java.util.List;

import com.administracion.contrato.model.ClientModel;

public interface ClientService {
	
	ClientModel getClientByRfc (String rfc);
	
	List<ClientModel> getClientByClientTypeAndContractPeriod ();

}
