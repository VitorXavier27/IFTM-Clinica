package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.PedidoDTO;
import com.ClinicaMedica.IFTM.entities.Pedido;
import com.ClinicaMedica.IFTM.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<PedidoDTO> findAll(){
		List<Pedido> result = pedidoRepository.findAll();
		List<PedidoDTO> dto = result.stream().map(x -> new PedidoDTO(x)).toList();
		return dto;
	}
	
	public Pedido salvar(Pedido salvarPedido) {
		return pedidoRepository.save(salvarPedido);
	}
}
