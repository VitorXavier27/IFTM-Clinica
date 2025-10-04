package com.ClinicaMedica.IFTM.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_exame")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Exame;
	private String tipo_Exame;
	private LocalDate data_Exame;
	private String resultado_Exame;
	private String status_Exame;
	@JoinColumn(name = "id_pacientes",referencedColumnName = "id_Paciente")
	@ManyToOne(fetch = FetchType.EAGER)
	private Paciente paciente; 
	
	public Exame() {
		
	}

	public Exame(Long id_Exame, String tipo_Exame, LocalDate data_Exame, String resultado_Exame, String status_Exame,String id_Paciente,Paciente paciente) {
		this.id_Exame = id_Exame;
		this.tipo_Exame = tipo_Exame;
		this.data_Exame = data_Exame;
		this.resultado_Exame = resultado_Exame;
		this.status_Exame = status_Exame;
		this.paciente = paciente;
	}

	public Long getId_Exame() {
		return id_Exame;
	}

	public void setId_Exame(Long id_Exame) {
		this.id_Exame = id_Exame;
	}

	public String getTipo_Exame() {
		return tipo_Exame;
	}

	public void setTipo_Exame(String tipo_Exame) {
		this.tipo_Exame = tipo_Exame;
	}

	public LocalDate getData_Exame() {
		return data_Exame;
	}

	public void setData_Exame(LocalDate data_Exame) {
		this.data_Exame = data_Exame;
	}

	public String getResultado_Exame() {
		return resultado_Exame;
	}

	public void setResultado_Exame(String resultado_Exame) {
		this.resultado_Exame = resultado_Exame;
	}

	public String getStatus_Exame() {
		return status_Exame;
	}

	public void setStatus_Exame(String status_Exame) {
		this.status_Exame = status_Exame;
	}

	public String getNome_paciente() {
		return paciente != null ? paciente.getNome_Paciente() : null;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	



	
	
	
	
}
