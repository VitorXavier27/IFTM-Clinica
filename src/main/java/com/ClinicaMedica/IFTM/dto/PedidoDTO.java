package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Pedido;

public class PedidoDTO {

	private Long id_Pedido;
	private String tipo_Pedido;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido entity) {
		
		id_Pedido = entity.getId_Pedido();
		tipo_Pedido = entity.getTipo_Pedido();
	}

	public Long getId_Pedido() {
		return id_Pedido;
	}

	public String getTipo_Pedido() {
		return tipo_Pedido;
	}
	
}
