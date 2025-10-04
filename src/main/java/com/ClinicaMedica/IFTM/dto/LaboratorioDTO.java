package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Laboratorio;

public class LaboratorioDTO {

	private Long id_Laboratorio;
	private String nome_Laboratorio;
	private String endereco_Laboratio;
	private String responsavel_Tecnico_laboratorio;
	
	public LaboratorioDTO() {
		
	}
	
	public LaboratorioDTO(Laboratorio entity) {
		id_Laboratorio = entity.getId_Laboratorio();
		nome_Laboratorio = entity.getNome_Laboratorio();
		endereco_Laboratio = entity.getEndereco_Laboratio();
		responsavel_Tecnico_laboratorio = entity.getResponsavel_Tecnico_laboratorio();
	}

	public Long getId_Laboratorio() {
		return id_Laboratorio;
	}

	public String getNome_Laboratorio() {
		return nome_Laboratorio;
	}

	public String getEndereco_Laboratio() {
		return endereco_Laboratio;
	}

	public String getResponsavel_Tecnico_laboratorio() {
		return responsavel_Tecnico_laboratorio;
	}
	
	
}
