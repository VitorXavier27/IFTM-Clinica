package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_laboratorio")
public class Laboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Laboratorio;
	private String nome_Laboratorio;
	private String endereco_Laboratio;
	private String responsavel_Tecnico_laboratorio;
	
	public Laboratorio() {
		
	}

	public Laboratorio(Long id_Laboratorio, String nome_Laboratorio, String endereco_Laboratio,
			String responsavel_Tecnico_laboratorio) {
		this.id_Laboratorio = id_Laboratorio;
		this.nome_Laboratorio = nome_Laboratorio;
		this.endereco_Laboratio = endereco_Laboratio;
		this.responsavel_Tecnico_laboratorio = responsavel_Tecnico_laboratorio;
	}

	public Long getId_Laboratorio() {
		return id_Laboratorio;
	}

	public void setId_Laboratorio(Long id_Laboratorio) {
		this.id_Laboratorio = id_Laboratorio;
	}

	public String getNome_Laboratorio() {
		return nome_Laboratorio;
	}

	public void setNome_Laboratorio(String nome_Laboratorio) {
		this.nome_Laboratorio = nome_Laboratorio;
	}

	public String getEndereco_Laboratio() {
		return endereco_Laboratio;
	}

	public void setEndereco_Laboratio(String endereco_Laboratio) {
		this.endereco_Laboratio = endereco_Laboratio;
	}

	public String getResponsavel_Tecnico_laboratorio() {
		return responsavel_Tecnico_laboratorio;
	}

	public void setResponsavel_Tecnico_laboratorio(String responsavel_Tecnico_laboratorio) {
		this.responsavel_Tecnico_laboratorio = responsavel_Tecnico_laboratorio;
	}


	
}
