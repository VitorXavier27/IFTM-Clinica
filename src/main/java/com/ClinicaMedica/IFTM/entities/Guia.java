package com.ClinicaMedica.IFTM.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_guia")
public class Guia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Guia;
	private LocalDate data_Emissao_Guia;
	private String convenio_Guia;
	
	public Guia() {
		
	}

	public Guia(Long id_Guia, LocalDate data_Emissao_Guia, String convenio_Guia) {
		this.id_Guia = id_Guia;
		this.data_Emissao_Guia = data_Emissao_Guia;
		this.convenio_Guia = convenio_Guia;
	}

	public Long getId_Guia() {
		return id_Guia;
	}

	public void setId_Guia(Long id_Guia) {
		this.id_Guia = id_Guia;
	}

	public LocalDate getData_Emissao_Guia() {
		return data_Emissao_Guia;
	}

	public void setData_Emissao_Guia(LocalDate data_Emissao_Guia) {
		this.data_Emissao_Guia = data_Emissao_Guia;
	}

	public String getConvenio_Guia() {
		return convenio_Guia;
	}

	public void setConvenio_Guia(String convenio_Guia) {
		this.convenio_Guia = convenio_Guia;
	}
	
	
	
	
	
}
