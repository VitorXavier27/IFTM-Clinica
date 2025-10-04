package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Equipamento;

public class EquipamentoDTO {

	private Long id_Equipamento;
	private String modelo_Equipamento;
	private String fabricante_Equipamento;
	private String status_Operacao;
	
	public EquipamentoDTO() {
		
	}
	
	public EquipamentoDTO(Equipamento entity) {
		id_Equipamento = entity.getId_Equipamento();
		modelo_Equipamento = entity.getModelo_Equipamento();
		fabricante_Equipamento = entity.getFabricante_Equipamento();
		status_Operacao = entity.getStatus_Operacao();
	}

	public Long getId_Equipamento() {
		return id_Equipamento;
	}

	public String getModelo_Equipamento() {
		return modelo_Equipamento;
	}

	public String getFabricante_Equipamento() {
		return fabricante_Equipamento;
	}

	public String getStatus_Operacao() {
		return status_Operacao;
	}
	
	
}
