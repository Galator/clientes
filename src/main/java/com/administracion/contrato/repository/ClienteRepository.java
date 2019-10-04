package com.administracion.contrato.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.administracion.contrato.entity.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity, String> {
	
	Optional<List<ClienteEntity>> findAllByTipoClienteAndFechaNacimientoCreacionLessThanEqual(String tipoCliente, LocalDate date);
	
	Optional<List<ClienteEntity>> findAllByTipoClienteAndContratosFechaContratoGreaterThanEqual(String tipoCliente, LocalDate date);

}
