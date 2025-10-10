package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;

import com.ClinicaMedica.IFTM.entities.Guia;

public class GuiaDTO {

	private Long id_Guia;
	private LocalDate data_Emissao_Guia;
	private String convenio_Guia;
	private String numero_Guia;
	
	public GuiaDTO () {
		
	}
	
	public GuiaDTO(Guia entity) {
		id_Guia = entity.getId_Guia();
		data_Emissao_Guia = entity.getData_Emissao_Guia();
		convenio_Guia = entity.getConvenio_Guia();
		numero_Guia = entity.getNumero_Guia();
	}

	public Long getId_Guia() {
		return id_Guia;
	}

	public LocalDate getData_Emissao_Guia() {
		return data_Emissao_Guia;
	}

	public String getConvenio_Guia() {
		return convenio_Guia;
	}

	public String getNumero_Guia() {
		return numero_Guia;
	}
	
	
}
