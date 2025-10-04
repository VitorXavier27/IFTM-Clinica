package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;

import com.ClinicaMedica.IFTM.entities.Paciente;

public class PacienteDTO {

	private Long idPaciente;
	private String nomePaciente;
	private String cpfPaciente;
	private LocalDate dataNascimentoPaciente;
	private String enderecoPaciente;
	private String telefonePaciente;
	private String emailPaciente;
	
	public PacienteDTO () {
		
	}
	
	public PacienteDTO(Paciente entity) {
		idPaciente = entity.getId_Paciente();
		nomePaciente = entity.getNome_Paciente();
		cpfPaciente = entity.getCpf_Paciente();
		dataNascimentoPaciente = entity.getData_Nascimento_Paciente();
		enderecoPaciente = entity.getEndereco_Paciente();
		telefonePaciente = entity.getTelefone_Paciente();
		emailPaciente = entity.getEmail_Paciente();
		
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public LocalDate getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}
	
	
}
