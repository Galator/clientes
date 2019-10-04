package com.administracion.contrato.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.administracion.contrato.model.ClientModel;
import com.administracion.contrato.service.AnnexService;
import com.administracion.contrato.service.ClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(maxAge = 3600)
public class AdministracionController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AnnexService annexService;
	
	@ApiOperation(value = "Actualiza el plazo de pago de las unidades cuyo numero de serie termina en 'FG45'", response = ResponseEntity.class)
	@GetMapping(value = "/Annex", produces= MediaType.APPLICATION_JSON_VALUE)
	public String validarServicio() {
		
		annexService.updatePeriod();
		
		return "Registros actualizados";
	}
	
	@ApiOperation(value = "Realiza la consulta de un cliente por RFC", response = ResponseEntity.class)
	@GetMapping(value = "/client/{rfc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClient(@PathVariable(required = true) String rfc) {

		HttpStatus http = HttpStatus.OK;

		ClientModel client = clientService.getClientByRfc(rfc);

		if (client == null) {
			http = HttpStatus.NO_CONTENT;
		}

		return new ResponseEntity<ClientModel>(client, http);
	}
	
	@ApiOperation(value = "Realiza la consulta de todos los clientes morales con contratos de los ultimos 3 anios", response = ResponseEntity.class)
	@GetMapping(value = "/client/Type", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClientType() {

		HttpStatus http = HttpStatus.OK;

		List<ClientModel> clients = clientService.getClientByClientTypeAndContractPeriod();

		if (clients.isEmpty()) {
			clients = Collections.emptyList();
			http = HttpStatus.NO_CONTENT;
		}

		return new ResponseEntity<List<ClientModel>>(clients, http);
	}

}
