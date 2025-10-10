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
	private String tipo_Analise;
	private String descricao_TipoAnalise;
	private String instrucao_TipoAnalise;

	
	public TipoAnalise() {
		
	}

	public TipoAnalise(Long id_TipoAnalise, String descricao_TipoAnalise , String tipo_Analise, String instrucao_TipoAnalise) {
		this.id_TipoAnalise = id_TipoAnalise;
		this.descricao_TipoAnalise = descricao_TipoAnalise;
		this.tipo_Analise = tipo_Analise;
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

	public String getTipo_Analise() {
		return tipo_Analise;
	}

	public void setTipo_Analise(String tipo_Analise) {
		this.tipo_Analise = tipo_Analise;
	}

	public String getInstrucao_TipoAnalise() {
		return instrucao_TipoAnalise;
	}

	public void setInstrucao_TipoAnalise(String instrucao_TipoAnalise) {
		this.instrucao_TipoAnalise = instrucao_TipoAnalise;
	}

	
	
	
}
