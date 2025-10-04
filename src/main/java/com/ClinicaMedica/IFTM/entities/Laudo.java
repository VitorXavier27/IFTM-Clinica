package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table  (name = "tb_laudo")
public class Laudo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Laudo;
	private String tipo_Laudo;
	
	public Laudo() {
		
	}

	public Laudo(Long id_Laudo, String tipo_Laudo) {
		this.id_Laudo = id_Laudo;
		this.tipo_Laudo = tipo_Laudo;
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
	
	
}
