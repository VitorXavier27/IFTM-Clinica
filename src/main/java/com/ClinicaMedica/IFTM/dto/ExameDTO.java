package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;

import com.ClinicaMedica.IFTM.entities.Exame;

public class ExameDTO {

	private Long id_Exame;
	private String tipo_Exame;
	private LocalDate data_Exame;
	private String resultado_Exame;
	private String status_Exame;
	private String nome_Paciente;
	private Long pacienteId;
	
	public ExameDTO () {
		
	}
	
	public ExameDTO(Exame entity) {
		
		id_Exame = entity.getId_Exame();
		tipo_Exame = entity.getTipo_Exame();
		data_Exame = entity.getData_Exame();
		resultado_Exame = entity.getResultado_Exame();
		status_Exame = entity.getStatus_Exame();
		nome_Paciente = entity.getNome_paciente()!= null? entity.getNome_paciente(): null;
		nome_Paciente = entity.getNome_paciente();
	}

	public Long getId_Exame() {
		return id_Exame;
	}

	public String getTipo_Exame() {
		return tipo_Exame;
	}

	public LocalDate getData_Exame() {
		return data_Exame;
	}

	public String getResultado_Exame() {
		return resultado_Exame;
	}

	public String getStatus_Exame() {
		return status_Exame;
	}

	public String getNome_Paciente() {
		return nome_Paciente;
	}

	public Long getPacienteId() {
		return pacienteId;
	}
	
	
	
	
}
