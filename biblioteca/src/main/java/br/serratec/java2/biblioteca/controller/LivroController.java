package br.serratec.java2.biblioteca.controller;

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

import br.serratec.java2.biblioteca.dto.LivroDto;
import br.serratec.java2.biblioteca.exception.LivroException;
import br.serratec.java2.biblioteca.model.Livro;
import br.serratec.java2.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

	
	@Autowired
	LivroService livroService;
	
	//listar todos os livros
	@GetMapping("/lista")
	public ResponseEntity<List<Livro>> listaTodos(){
		return ResponseEntity.ok(livroService.listarTodos());		
	}
	@GetMapping("/buscar/{idLivro")
	public ResponseEntity<LivroDto> buscarPorId(@PathVariable Integer idLivro) throws LivroException{
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> salvar(@RequestBody LivroDto livroDto) throws LivroException {
		livroService.salvar(livroDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idLivro,@RequestBody LivroDto livroDto){
		livroService.atualizar(idLivro, livroDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deletar/{idLivro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idLivro){ 
		livroService.delete(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}