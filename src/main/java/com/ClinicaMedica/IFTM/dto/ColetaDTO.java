package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;

import com.ClinicaMedica.IFTM.entities.Coleta;

public class ColetaDTO {

	private Long id_Coleta;
	private LocalDate data_Coletagem;
	private String tipo_Material_Coleta;
	private String local_Coleta;
	
	public ColetaDTO() {
		
	}
	
	public ColetaDTO(Coleta entity) {
		
		id_Coleta = entity.getId_Coleta();
		data_Coletagem = entity.getData_Coletagem();
		tipo_Material_Coleta = entity.getTipo_Material_Coleta();
		local_Coleta = entity.getLocal_Coleta();
	}

	public Long getId_Coleta() {
		return id_Coleta;
	}

	public LocalDate getData_Coletagem() {
		return data_Coletagem;
	}

	public String getTipo_Material_Coleta() {
		return tipo_Material_Coleta;
	}

	public String getLocal_Coleta() {
		return local_Coleta;
	}
	
	
}
