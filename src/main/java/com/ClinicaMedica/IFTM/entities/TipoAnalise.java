package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_tipoAnalise")
public class TipoAnalise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_TipoAnalise;
	private String descricao_TipoAnalise;
	
	public TipoAnalise() {
		
	}

	public TipoAnalise(Long id_TipoAnalise, String descricao_TipoAnalise) {
		this.id_TipoAnalise = id_TipoAnalise;
		this.descricao_TipoAnalise = descricao_TipoAnalise;
	}

	public Long getId_TipoAnalise() {
		return id_TipoAnalise;
	}

	public void setId_TipoAnalise(Long id_TipoAnalise) {
		this.id_TipoAnalise = id_TipoAnalise;
	}

	public String getDescricao_TipoAnalise() {
		return descricao_TipoAnalise;
	}

	public void setDescricao_TipoAnalise(String descricao_TipoAnalise) {
		this.descricao_TipoAnalise = descricao_TipoAnalise;
	}
	
	
}
