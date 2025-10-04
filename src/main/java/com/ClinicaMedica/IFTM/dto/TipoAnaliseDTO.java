package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.TipoAnalise;

public class TipoAnaliseDTO {

	private Long id_TipoAnalise;
	private String descricao_TipoAnalise;
	
	public TipoAnaliseDTO () {
		
	}
	
	public TipoAnaliseDTO (TipoAnalise entity) {
		
		id_TipoAnalise = entity.getId_TipoAnalise();
		descricao_TipoAnalise = entity.getDescricao_TipoAnalise();
	}

	public Long getId_TipoAnalise() {
		return id_TipoAnalise;
	}

	public String getDescricao_TipoAnalise() {
		return descricao_TipoAnalise;
	}
	
	
}
