package org.serratec.java2backend.projetocrud.controller;

import java.util.List;

import org.serratec.java2backend.projetocrud.model.Escola;
import org.serratec.java2backend.projetocrud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escola")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/lista")
	public List<Escola> getTodo(){
		return todoService.listaEscola();
	}
	
	@PostMapping("/adicionar")
	public void adicionar(@RequestBody Escola escola) {
		todoService.adicionar(escola);
	}
	
	@PutMapping("/atualizar/{idPosicao}")
	public void atualizar(@PathVariable int idPosicao, @RequestBody Escola infoEditada) {
		todoService.atualizar(idPosicao, infoEditada);
	}
	@DeleteMapping("/deletar/{idPosicao}")
	public void deletar(@PathVariable int idPosicao) {
		todoService.deletar(idPosicao);
	}

	
}
