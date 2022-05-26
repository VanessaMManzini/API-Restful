package br.serratec.javab2backend.projeto04.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	
	//controla as mensagens de erro
	@ExceptionHandler(TodoException.class)
	public ResponseEntity<String> TrataTodoNotFound(TodoException exception){
		String msg = String.format("O todo com ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "TODO NOT FOUND")
				.header("x-erro-value", exception.getId().toString())
				.build();
	
	
	
	}

}
