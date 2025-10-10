package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table  (name = "tb_laudo")
public class Laudo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Laudo;
	private String tipo_Laudo;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pacientes", referencedColumnName = "id_Paciente")
	private Paciente paciente;
	
	public Laudo() {
		
	}

	public Laudo(Long id_Laudo, String tipo_Laudo , Paciente paciente) {
		this.id_Laudo = id_Laudo;
		this.tipo_Laudo = tipo_Laudo;
		this.paciente = paciente;
	}

	public Long getId_Laudo() {
		return id_Laudo;
	}

	public void setId_Laudo(Long id_Laudo) {
		this.id_Laudo = id_Laudo;
	}

	public String getTipo_Laudo() {
		return tipo_Laudo;
	}

	public void setTipo_Laudo(String tipo_Laudo) {
		this.tipo_Laudo = tipo_Laudo;
	}

	public String getNome_Paciente() {
		return paciente.getNome_Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	
	
}
