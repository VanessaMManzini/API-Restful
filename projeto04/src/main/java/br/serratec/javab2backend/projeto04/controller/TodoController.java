package br.serratec.javab2backend.projeto04.controller;


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

import br.serratec.javab2backend.projeto04.exception.TodoException;
import br.serratec.javab2backend.projeto04.model.Todo;
import br.serratec.javab2backend.projeto04.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/lista")
	public List<Todo> getTodo(){
		return todoService.listaTodo();
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Todo todo) {
		todoService.adicionar(todo);
		return new ResponseEntity<>(HttpStatus.CREATED);
}
	
	@GetMapping("/buscar/{idTodo}")
		public ResponseEntity<Todo> buscarPorId(@PathVariable Integer idTodo) throws TodoException {
		return ResponseEntity.ok(todoService.buscarPorId(idTodo));
	}
		
	@PutMapping("/atualizar/{posicaoLista}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer posicaoLista,@RequestBody Todo todoDaApi) {
		todoService.atualizar(posicaoLista, todoDaApi);	
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{posicaoLista}")
	public ResponseEntity<Void> deletar(@PathVariable int posicaoLista){
		todoService.deletar(posicaoLista);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	//@GetMapping("/find/{idTodo}")
	//public ResponseEntity<List<Todo>> findById(@PathVariable Integer idTodo){
	//			return ResponseEntity.ok(todoService.findById(idTodo));
//	}
	
}
