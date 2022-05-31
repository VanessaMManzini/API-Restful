package br.serratec.java2backend.borracharia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.java2backend.borracharia.DTO.ClienteDTO;
import br.serratec.java2backend.borracharia.exception.ClienteException;
import br.serratec.java2backend.borracharia.model.Cliente;
import br.serratec.java2backend.borracharia.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	
	@Autowired
	ClienteService clienteService;
	
	//Listar todos os clientes 
	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(clienteService.listarTodos());
	}
	//Buscar por id
	@GetMapping("/buscar/{idCliente")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	//Adicionar 
	@PostMapping("/adicionar")
	public ResponseEntity<Void> salvar (@RequestBody ClienteDTO clienteDTO) throws ClienteException{
		clienteService.salvar(clienteDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//Atualizar por id
	@PutMapping("/atualizar/{idCliente")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO ) {
		clienteService.atualizar(idCliente, clienteDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	//Deletar
	@DeleteMapping("/deletar/{idCliente}")
	public ResponseEntity<Void> delete (@PathVariable Integer idCliente){
		clienteService.delete(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
	
	
	
	

