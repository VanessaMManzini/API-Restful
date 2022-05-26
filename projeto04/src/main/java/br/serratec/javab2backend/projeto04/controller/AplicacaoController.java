package br.serratec.javab2backend.projeto04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.javab2backend.projeto04.model.AplicacaoConfig;


@RestController
public class AplicacaoController {
	
	
	@Autowired
	
	private AplicacaoConfig aplicacaoConfig;
	
	@GetMapping("/config")
	public AplicacaoConfig retornarConfig() {
		return aplicacaoConfig;
	}
}
