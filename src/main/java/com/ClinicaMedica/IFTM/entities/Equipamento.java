package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_equipamento")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Equipamento;
	private String modelo_Equipamento;
	private String fabricante_Equipamento;
	private String status_Operacao;
	
	public Equipamento() {
		
	}

	public Equipamento(Long id_Equipamento, String modelo_Equipamento, String fabricante_Equipamento,
			String status_Operacao) {
		this.id_Equipamento = id_Equipamento;
		this.modelo_Equipamento = modelo_Equipamento;
		this.fabricante_Equipamento = fabricante_Equipamento;
		this.status_Operacao = status_Operacao;
	}

	public Long getId_Equipamento() {
		return id_Equipamento;
	}

	public void setId_Equipamento(Long id_Equipamento) {
		this.id_Equipamento = id_Equipamento;
	}

	public String getModelo_Equipamento() {
		return modelo_Equipamento;
	}

	public void setModelo_Equipamento(String modelo_Equipamento) {
		this.modelo_Equipamento = modelo_Equipamento;
	}

	public String getFabricante_Equipamento() {
		return fabricante_Equipamento;
	}

	public void setFabricante_Equipamento(String fabricante_Equipamento) {
		this.fabricante_Equipamento = fabricante_Equipamento;
	}

	public String getStatus_Operacao() {
		return status_Operacao;
	}

	public void setStatus_Operacao(String status_Operacao) {
		this.status_Operacao = status_Operacao;
	}
	
	
}
