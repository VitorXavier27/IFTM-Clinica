package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.TipoAnalise;

public class TipoAnaliseDTO {

	private Long id_TipoAnalise;
	private String descricao_TipoAnalise;
	private String tipo_Analise;
	private String instrucao_TipoAnalise;
	
	public TipoAnaliseDTO () {
		
	}
	
	public TipoAnaliseDTO (TipoAnalise entity) {
		
		id_TipoAnalise = entity.getId_TipoAnalise();
		descricao_TipoAnalise = entity.getDescricao_TipoAnalise();
		tipo_Analise = entity.getTipo_Analise();
		instrucao_TipoAnalise = entity.getInstrucao_TipoAnalise();
	}

	public Long getId_TipoAnalise() {
		return id_TipoAnalise;
	}

	public String getDescricao_TipoAnalise() {
		return descricao_TipoAnalise;
	}

	public String getTipo_Analise() {
		return tipo_Analise;
	}

	public String getInstrucao_TipoAnalise() {
		return instrucao_TipoAnalise;
	}
	
	
	
}
