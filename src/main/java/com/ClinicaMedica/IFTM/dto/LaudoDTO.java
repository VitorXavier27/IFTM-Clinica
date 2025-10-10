package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Laudo;

public class LaudoDTO {

	private Long id_Laudo;
	private String tipo_Laudo;
	private String nome_Paciente;
	
	public LaudoDTO() {
		
	}
	
	public LaudoDTO(Laudo entity) {
		id_Laudo = entity.getId_Laudo();
		tipo_Laudo = entity.getTipo_Laudo();
		nome_Paciente = entity.getNome_Paciente();
	}

	public Long getId_Laudo() {
		return id_Laudo;
	}

	public String getTipo_Laudo() {
		return tipo_Laudo;
	}

	public String getNome_Paciente() {
		return nome_Paciente;
	}
	
	
	
}
