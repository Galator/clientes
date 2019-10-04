package com.administracion.contrato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.contrato.repository.AnexoRepository;

@Service
public class AnnexServiceImpl implements AnnexService {

	@Autowired
	private AnexoRepository anexoRepository;

	@Override
	public void updatePeriod() {

		anexoRepository.findByNumeroSerieEndingWith("FG45").ifPresent(entity -> entity.forEach(annex -> {
			annex.setPlazo(48);

			anexoRepository.save(annex);
		}));
	}

}
