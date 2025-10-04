package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_amostra")
public class Amostra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Amostra;
	private String codigo_Rastreamento_Amostra;
	private String status_Amostra;
	
	public Amostra() {
		
	}

	public Amostra(Long id_Amostra, String codigo_Rastreamento_Amostra, String status_Amostra) {
		this.id_Amostra = id_Amostra;
		this.codigo_Rastreamento_Amostra = codigo_Rastreamento_Amostra;
		this.status_Amostra = status_Amostra;
	}

	public Long getId_Amostra() {
		return id_Amostra;
	}

	public void setId_Amostra(Long id_Amostra) {
		this.id_Amostra = id_Amostra;
	}

	public String getCodigo_Rastreamento_Amostra() {
		return codigo_Rastreamento_Amostra;
	}

	public void setCodigo_Rastreamento_Amostra(String codigo_Rastreamento_Amostra) {
		this.codigo_Rastreamento_Amostra = codigo_Rastreamento_Amostra;
	}

	public String getStatus_Amostra() {
		return status_Amostra;
	}

	public void setStatus_Amostra(String status_Amostra) {
		this.status_Amostra = status_Amostra;
	}
	
	
	
}
