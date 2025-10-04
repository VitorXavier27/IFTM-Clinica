package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.PedidoDTO;
import com.ClinicaMedica.IFTM.entities.Pedido;
import com.ClinicaMedica.IFTM.service.PedidoService;

@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/pedido")
public class PedidoControle {

	@Autowired
	private PedidoService pedidoService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public List<PedidoDTO> findAll(){
		List<PedidoDTO> result = pedidoService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Pedido cadastroPedido(@RequestBody Pedido pedidoCadastro) {
		Pedido pedidoSalvo = pedidoService.salvar(pedidoCadastro);
		return pedidoSalvo;
	}
}
