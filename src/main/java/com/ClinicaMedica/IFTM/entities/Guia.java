package com.ClinicaMedica.IFTM.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_guia")
public class Guia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Guia;
	private Instant data_Emissao_Guia;
	private String convenio_Guia;
	private String numero_Guia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "id_pacientes" , referencedColumnName = "id_Paciente")
	private Paciente paciente;
	
	public Guia() {
		
	}

	public Guia(Long id_Guia, Instant data_Emissao_Guia, String convenio_Guia , String numero_Guia, Paciente paciente) {
		this.id_Guia = id_Guia;
		this.data_Emissao_Guia = data_Emissao_Guia;
		this.convenio_Guia = convenio_Guia;
		this.numero_Guia = numero_Guia;
		this.paciente = paciente;
	}
	

	public Long getId_Guia() {
		return id_Guia;
	}

	public void setId_Guia(Long id_Guia) {
		this.id_Guia = id_Guia;
	}

	public Instant getData_Emissao_Guia() {
		return data_Emissao_Guia;
	}

	public void setData_Emissao_Guia(Instant instant) {
		this.data_Emissao_Guia = instant;
	}

	public String getConvenio_Guia() {
		return convenio_Guia;
	}

	public void setConvenio_Guia(String convenio_Guia) {
		this.convenio_Guia = convenio_Guia;
	}

	public String getNumero_Guia() {
		return numero_Guia;
	}

	public void setNumero_Guia(String numero_Guia) {
		this.numero_Guia = numero_Guia;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String getNome_paciente() {
		return paciente != null ? paciente.getNome_Paciente() : null;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	
}
