package br.serratec.java2backend.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

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

import br.serratec.java2backend.borracharia.DTO.RelatorioDTO;
import br.serratec.java2backend.borracharia.DTO.TabelaDeServicoDTO;
import br.serratec.java2backend.borracharia.exception.EmailException;
import br.serratec.java2backend.borracharia.exception.TabelaDeServicoExcpetion;
import br.serratec.java2backend.borracharia.model.TabelaDeServico;
import br.serratec.java2backend.borracharia.service.TabelaDeServicoService;

@RestController
@RequestMapping("tabela")
public class TabelaDeServicoController {

		@Autowired
		TabelaDeServicoService tabelaDeServicoService;
		
		//Listar todos as tabelas
		@GetMapping("/lista")
		public ResponseEntity<List<TabelaDeServico>> listarTodos(){
			return ResponseEntity.ok(tabelaDeServicoService.listarTodos());
		}
		//Buscar por id
		@GetMapping("/buscar/{idTabelaDeServico}")
		public ResponseEntity<TabelaDeServicoDTO> buscarPorId(@PathVariable Integer idTabelaDeServico) throws TabelaDeServicoExcpetion{
			return ResponseEntity.ok(tabelaDeServicoService.buscarPorId(idTabelaDeServico));
		}
		//Adicionar 
		@PostMapping("/adicionar")
		public ResponseEntity<Void> salvar (@RequestBody TabelaDeServicoDTO tabelaDeServicoDTO) throws TabelaDeServicoExcpetion, MessagingException, EmailException{
			tabelaDeServicoService.salvar(tabelaDeServicoDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		//Atuaizar por id
		@PutMapping("/atualizar/{idTabelaDeServico}")
		public ResponseEntity<Void> atualizar(@PathVariable Integer idTabelaDeServico, @RequestBody TabelaDeServicoDTO tabelaDeServicoDTO) {
			tabelaDeServicoService.atualizar(idTabelaDeServico, tabelaDeServicoDTO);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		//Deletar
		@DeleteMapping("/deletar/{idTabelaDeServico}")
		public ResponseEntity<Void> delete (@PathVariable Integer idTabelaDeServico){
			tabelaDeServicoService.delete(idTabelaDeServico);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		@GetMapping("/relatorio")
		public ResponseEntity<List<RelatorioDTO>> listarRelatorio(){
			return ResponseEntity.ok(tabelaDeServicoService.relatorio());
			
		}
		
	}
