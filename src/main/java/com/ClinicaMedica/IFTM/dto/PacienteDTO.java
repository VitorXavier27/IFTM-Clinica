package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PacienteDTO {

	private Long idPaciente;
    @JsonProperty("nome_Paciente")
	private String nomePaciente;
    @JsonProperty("cpf_Paciente")
	private String cpfPaciente;
    @JsonProperty("data_Nascimento_Paciente")
	private LocalDate dataNascimentoPaciente;
    @JsonProperty("endereco_Paciente")
	private String enderecoPaciente;
    @JsonProperty("telefone_Paciente")
	private String telefonePaciente;
    @JsonProperty("email_Paciente")
	private String emailPaciente;
    private List<MedicosDTO> medics = new ArrayList<>();
	
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

    public List<MedicosDTO> getMedics() {
        return medics;
    }
}
