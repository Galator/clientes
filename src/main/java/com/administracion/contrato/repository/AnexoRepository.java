package com.administracion.contrato.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.administracion.contrato.entity.AnexoEntity;

public interface AnexoRepository extends CrudRepository<AnexoEntity, Integer> {
	
	Optional<List<AnexoEntity>> findByNumeroSerieEndingWith(String terminacion);

}
