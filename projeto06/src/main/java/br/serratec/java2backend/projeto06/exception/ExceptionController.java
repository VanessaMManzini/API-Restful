package br.serratec.java2backend.projeto06.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ContaException.class)
	public ResponseEntity<String> trataContaNotFound(ContaException exception){
		String msg = String.format("A conta com o Número %d não foi encontrada", exception.getNumeroConta());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "CONTA NOT FOUND")
				.header("x-erro-value",exception.getNumeroConta().toString())
				.build();
	}
	
	@ExceptionHandler(OperacaoException.class)
	public ResponseEntity<String> trataSaldoInsuficiente(OperacaoException exception){
		String msg = String.format("Saldo insuficiente para realizar a operação");
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "SALDO INSUFICIENTE")
				.header("x-erro-value")
				.build();
	}
}