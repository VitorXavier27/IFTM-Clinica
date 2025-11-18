package com.ClinicaMedica.IFTM.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PacienteDTO {

    private Long id_Paciente;
    private String nome_Paciente;
    private String cpf_Paciente;
//@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_Nascimento_Paciente;
    private String endereco_Paciente;
    private String telefone_Paciente;
    private String email_Paciente;
    private List<MedicosDTO> medics = new ArrayList<>();
	
	public PacienteDTO () {
		
	}
	
	public PacienteDTO(Paciente entity) {
		id_Paciente = entity.getId_Paciente();
		nome_Paciente = entity.getNome_Paciente();
		cpf_Paciente = entity.getCpf_Paciente();
		data_Nascimento_Paciente = entity.getData_Nascimento_Paciente();
		endereco_Paciente = entity.getEndereco_Paciente();
		telefone_Paciente = entity.getTelefone_Paciente();
		email_Paciente = entity.getEmail_Paciente();
		
	}

	public Long getIdPaciente() {
		return id_Paciente;
	}

	public String getNome_Paciente() {
		return nome_Paciente;
	}

	public String getCpf_Paciente() {
		return cpf_Paciente;
	}

	public LocalDate getData_Nascimento_Paciente() {
		return data_Nascimento_Paciente;
	}

	public String getEndereco_Paciente() {
		return endereco_Paciente;
	}

	public String getTelefone_Paciente() {
		return telefone_Paciente;
	}

	public String getEmail_Paciente() {
		return email_Paciente;
	}

    public List<MedicosDTO> getMedics() {
        return medics;
    }
}
