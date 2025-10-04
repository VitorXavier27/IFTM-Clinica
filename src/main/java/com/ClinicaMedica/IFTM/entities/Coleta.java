package com.ClinicaMedica.IFTM.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_coleta")
public class Coleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Coleta;
	private LocalDate data_Coletagem;
	private String tipo_Material_Coleta;
	private String local_Coleta;
	
	public Coleta() {
		
	}

	public Coleta(Long id_Coleta, LocalDate data_Coletagem, String tipo_Material_Coleta, String local_Coleta) {
		this.id_Coleta = id_Coleta;
		this.data_Coletagem = data_Coletagem;
		this.tipo_Material_Coleta = tipo_Material_Coleta;
		this.local_Coleta = local_Coleta;
	}

	public Long getId_Coleta() {
		return id_Coleta;
	}

	public void setId_Coleta(Long id_Coleta) {
		this.id_Coleta = id_Coleta;
	}

	public LocalDate getData_Coletagem() {
		return data_Coletagem;
	}

	public void setData_Coletagem(LocalDate data_Coletagem) {
		this.data_Coletagem = data_Coletagem;
	}

	public String getTipo_Material_Coleta() {
		return tipo_Material_Coleta;
	}

	public void setTipo_Material_Coleta(String tipo_Material_Coleta) {
		this.tipo_Material_Coleta = tipo_Material_Coleta;
	}

	public String getLocal_Coleta() {
		return local_Coleta;
	}

	public void setLocal_Coleta(String local_Coleta) {
		this.local_Coleta = local_Coleta;
	}
	
	
	
}
