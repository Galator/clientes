package com.administracion.contrato.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.contrato.entity.ClienteEntity;
import com.administracion.contrato.model.ClientModel;
import com.administracion.contrato.repository.ClienteRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClientModel getClientByRfc(String rfc) {

		return clienteRepository.findById(rfc).map(client -> calcularEdad(new ClientModel(client))).orElse(null);

	}

	@Override
	public List<ClientModel> getClientByClientTypeAndContractPeriod() {

		List<ClientModel> clientList = new ArrayList<>();

		String clientType = "MORAL";
		LocalDate contractPeriod = LocalDate.now();
		contractPeriod = contractPeriod.minusYears(3);

		Optional<List<ClienteEntity>> clientes = clienteRepository
				.findAllByTipoClienteAndContratosFechaContratoGreaterThanEqual(clientType, contractPeriod);

		if (clientes.isPresent()) {
			System.out.println("elementos: " + clientes.get().size());
			for (ClienteEntity cliente : clientes.get()) {
				clientList.add(new ClientModel(cliente));
			}
		}

		/*
		 * clienteRepository.
		 * findAllByTipoClienteAndContratosFechaContratoGreaterThanEqual(clientType,
		 * contractPeriod) .ifPresent(list -> list.forEach(client ->
		 * clientList.add(calcularEdad(new ClientModel(client)))));
		 */
		return clientList;
	}

	private ClientModel calcularEdad(ClientModel client) {

		if ("FISICA".equals(client.getClientType())) {
			LocalDate ahora = LocalDate.now();

			Period period = Period.between(client.getClientDate(), ahora);

			StringBuilder years = new StringBuilder("Edad: ");
			years.append(period.getYears());
			years.append(" anios, ");
			years.append(period.getMonths());
			years.append(" meses y ");
			years.append(period.getDays());
			years.append(" dias");

			client.setCustomerAge(years.toString());
		}

		return client;
	}

}
