package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Medicos;

public class MedicosDTO {

	private Long id_Medico;
	private String nome_Medico;
	private String crm_Medico;
	private String especialidade_Medico;
	private String telefone_Medico;
	
	public MedicosDTO () {
		
	}
	
	public MedicosDTO(Medicos entity) {
		id_Medico = entity.getId_Medico();
		nome_Medico = entity.getNome_Medico();
		crm_Medico = entity.getCrm_Medico();
		especialidade_Medico= entity.getEspecialidade_Medico();
		telefone_Medico = entity.getTelefone_Medico();
	}

	public Long getId_Medico() {
		return id_Medico;
	}

	public String getNome_Medico() {
		return nome_Medico;
	}

	public String getCrm_Medico() {
		return crm_Medico;
	}

	public String getEspecialidade_Medico() {
		return especialidade_Medico;
	}

	public String getTelefone_Medico() {
		return telefone_Medico;
	}
	
	
}
