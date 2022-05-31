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

import br.serratec.java2backend.borracharia.DTO.CarroDTO;
import br.serratec.java2backend.borracharia.exception.CarroException;
import br.serratec.java2backend.borracharia.model.Carro;
import br.serratec.java2backend.borracharia.service.CarroService;

@RestController
@RequestMapping("carro")
public class CarroController {
	@Autowired
	CarroService carroService;
	
	//Listar todos os carros
	@GetMapping("/lista")
	public ResponseEntity<List<Carro>> listarTodos(){
		return ResponseEntity.ok(carroService.listarTodos());
	}
	//Buscar por id
	@GetMapping("/buscar/{idCarro")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws Exception{
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}
	//Adicionar 
	@PostMapping("/adicionar")
	public ResponseEntity<Void> salvar (@RequestBody CarroDTO carroDTO) throws CarroException{
		carroService.salvar(carroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//Atualizar por id
	@PutMapping("/atualizar/{idCarro")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO ) {
		carroService.atualizar(idCarro, carroDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	//Deletar
	@DeleteMapping("/deletar/{idCarro}")
	public ResponseEntity<Void> delete (@PathVariable Integer idCarro){
		carroService.delete(idCarro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}

