package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id_Pedido;
	private String tipo_Pedido;
	
	public Pedido() {
		
	}

	public Pedido(Long id_Pedido, String tipo_Pedido) {
		this.id_Pedido = id_Pedido;
		this.tipo_Pedido = tipo_Pedido;
	}

	public Long getId_Pedido() {
		return id_Pedido;
	}

	public void setId_Pedido(Long id_Pedido) {
		this.id_Pedido = id_Pedido;
	}

	public String getTipo_Pedido() {
		return tipo_Pedido;
	}

	public void setTipo_Pedido(String tipo_Pedido) {
		this.tipo_Pedido = tipo_Pedido;
	}
	
	
	
}
