package br.serratec.java2backend.projeto06.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.java2backend.projeto06.exception.ContaException;
import br.serratec.java2backend.projeto06.exception.OperacaoException;
import br.serratec.java2backend.projeto06.model.Conta;
import br.serratec.java2backend.projeto06.service.ContaService;


//pela ordem é o quarto pacote
@ RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService  contaService;
	
	//lista todas as contas
	@GetMapping("/lista")
	public ResponseEntity<List<Conta>> listaTodos(){
		return ResponseEntity.ok(contaService.listarTodos());
	}
	
	//buscar pelo id
	@GetMapping("/{numeroConta}")
	public ResponseEntity<Conta> buscarPorId(@PathVariable Integer numeroConta){
		return ResponseEntity.ok(contaService.buscarPorId(numeroConta));
	}
	@PostMapping("/salvar")
	public ResponseEntity<Void>salvar(@RequestBody Conta conta){
		contaService.salvar(conta);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	//atualizar 
	@PutMapping("/atualizar/{numeroConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idConta, @RequestBody Conta conta){
		contaService.atualizar(idConta, conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//deleta pelo numero
	@DeleteMapping("/delete/{numeroConta}") 
	public ResponseEntity<Void> deletar(@PathVariable Integer numeroConta){
		contaService.delete(numeroConta);
		return new ResponseEntity<> (HttpStatus.ACCEPTED);
	}
	@PutMapping("/saque/{numeroConta}")
	public ResponseEntity<Void> sacar(@PathVariable Integer numeroConta, @RequestParam float valor) throws OperacaoException {
		contaService.sacar(numeroConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/deposito/{numeroConta}")
	public ResponseEntity<Void> depositar(@PathVariable Integer numeroConta, @RequestParam float valor) throws ContaException{
		contaService.depositar(numeroConta, valor);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
