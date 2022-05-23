package br.serratec.java2backend.projeto06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.java2backend.projeto06.exception.ContaException;
import br.serratec.java2backend.projeto06.exception.OperacaoException;
import br.serratec.java2backend.projeto06.model.Conta;
import br.serratec.java2backend.projeto06.repository.ContaRepository;


//pela ordem é o terceiro pacote
@Service
public class ContaService {
	
	
	@Autowired
	ContaRepository contaRepository;
	

	public void salvar(Conta conta) {
		contaRepository.save(conta);
		//salvar os dados incluidos.. é o método salvar
		
	}
	public Conta buscarPorId(Integer idConta) {
		Optional<Conta> conta = contaRepository.findById(idConta);
		
		//conta vazia
		Conta contaNoBanco= new Conta();
		
		if(conta.isPresent()) {
			contaNoBanco = conta.get();
			
		}
		return contaNoBanco;
	}
	
	public void atualizar (Integer idConta, Conta conta) {
		Conta contaNoBanco = buscarPorId(idConta);
		//atualiza dado em opcao de um campo só
		if(conta.getTitularConta()!=null) {
		contaNoBanco.setTitular(conta.getTitularConta());
	}
		if(conta.getNumeroConta()!=null){
		contaNoBanco.setNumero(conta.getNumeroConta());	
	}
		
		contaRepository.save(contaNoBanco);
	}
	
		public void delete(Integer idConta) {
			 contaRepository.deleteById(idConta);
			 //usar o deleteById para não deletar tudo.
		}
		
		//retornar lista de contas
	public List<Conta> listarTodos(){
		return contaRepository.findAll();
	}
	
	//saque
		public void sacar(Integer numeroConta, float valor) throws OperacaoException {
			Conta contaOperacao = new Conta();
			for(Conta conta: listarTodos()) {
				if (conta.getNumeroConta().equals(numeroConta)) {
					contaOperacao = conta;
					contaOperacao.setSaldoConta(contaOperacao.getSaldoConta() - valor);
				}
			}
			
			if(contaOperacao.getSaldoConta() < valor) {
				throw new OperacaoException(valor);
			}
			
				
			contaRepository.save(contaOperacao);
		}
		
		//deposito.
		public void depositar(Integer numeroConta, float valor) throws ContaException{
			Conta contaOperacao = new Conta();
			for(Conta conta: listarTodos()) {
				if (conta.getNumeroConta().equals(numeroConta)) {
					contaOperacao = conta;
					contaOperacao.setSaldoConta(contaOperacao.getSaldoConta() + valor);
				}
			}
			
			if(contaOperacao.getNumeroConta() == null) {
				throw new ContaException(numeroConta);
			}
							
			contaRepository.save(contaOperacao);
		}
		
	
}
