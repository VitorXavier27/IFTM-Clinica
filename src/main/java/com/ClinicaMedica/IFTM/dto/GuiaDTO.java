package com.ClinicaMedica.IFTM.dto;

import java.time.Instant;

import com.ClinicaMedica.IFTM.entities.Guia;

public class GuiaDTO {

	private Long id_Guia;
	private Instant data_Emissao_Guia;
	private String convenio_Guia;
	private String numero_Guia;
	private String nome_Paciente;
	private Long pacienteId;
	
	public GuiaDTO () {
		
	}
	
	public GuiaDTO(Guia entity) {
		id_Guia = entity.getId_Guia();
		data_Emissao_Guia = entity.getData_Emissao_Guia();
		convenio_Guia = entity.getConvenio_Guia();
		numero_Guia = entity.getNumero_Guia();
		nome_Paciente = entity.getNome_paciente();
	}

	public Long getId_Guia() {
		return id_Guia;
	}

	public Instant getData_Emissao_Guia() {
		return data_Emissao_Guia;
	}

	public String getConvenio_Guia() {
		return convenio_Guia;
	}

	public String getNumero_Guia() {
		return numero_Guia;
	}

	public String getNome_Paciente() {
		return nome_Paciente;
	}

	public Long getPacienteId() {
		return pacienteId;
	}
	
	
}
