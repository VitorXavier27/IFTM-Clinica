package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Amostra;

public class AmostraDTO {

	private Long id_Amostra;
	private String codigo_Rastreamento_Amostra;
	private String status_Amostra;
	
	public AmostraDTO () {
		
	}
	
	public AmostraDTO (Amostra entity) {
		
		id_Amostra = entity.getId_Amostra();
		codigo_Rastreamento_Amostra = entity.getCodigo_Rastreamento_Amostra();
		status_Amostra = entity.getStatus_Amostra();
	}

	public Long getId_Amostra() {
		return id_Amostra;
	}

	public String getCodigo_Rastreamento_Amostra() {
		return codigo_Rastreamento_Amostra;
	}

	public String getStatus_Amostra() {
		return status_Amostra;
	}
	
	
}
