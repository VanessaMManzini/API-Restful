package br.serratec.java2backend.borracharia.service;

import java.util.List;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.java2backend.borracharia.DTO.RelatorioDTO;
import br.serratec.java2backend.borracharia.DTO.TabelaDeServicoDTO;
import br.serratec.java2backend.borracharia.exception.EmailException;
import br.serratec.java2backend.borracharia.exception.TabelaDeServicoExcpetion;
import br.serratec.java2backend.borracharia.model.TabelaDeServico;
import br.serratec.java2backend.borracharia.repository.TabelaDeServicoRepository;

@Service
public class TabelaDeServicoService{
	
	@Autowired
	TabelaDeServicoRepository tabelaDeServicoRepository;
	
	@Autowired
	EmailService emailService;
	
	public void salvar (TabelaDeServicoDTO tabelaDeServicoDTO) throws TabelaDeServicoExcpetion, MessagingException, EmailException {
		
		TabelaDeServico tabelaDeServico = new TabelaDeServico();
		TabelaDeServico tabelaDeServicoSalvar = new TabelaDeServico();
		tabelaDeServicoSalvar = dTOEmModel(tabelaDeServicoDTO,  tabelaDeServico);
		
		tabelaDeServicoRepository.save(tabelaDeServicoSalvar);
		emailService.emailTeste(tabelaDeServicoDTO);
		 	
	}
	
	public TabelaDeServicoDTO modelEmDTO(TabelaDeServicoDTO tabelaDeServicoDTO, TabelaDeServico tabelaDeServico) {
		tabelaDeServicoDTO.setIdServico(tabelaDeServico.getIdServico());
		tabelaDeServicoDTO.setDataServico(tabelaDeServico.getDataServico());
		tabelaDeServicoDTO.setServicoPrestado(tabelaDeServico.getServicoPrestado());
		tabelaDeServicoDTO.setValorServico(tabelaDeServico.getValorServico());
		tabelaDeServicoDTO.setIdCarro(tabelaDeServico.getCarro().getIdCarro());
		
		return tabelaDeServicoDTO;
		
	}
	
	public TabelaDeServico dTOEmModel(TabelaDeServicoDTO tabelaDeServicoDTO, TabelaDeServico tabelaDeServico) {
		tabelaDeServico.setDataServico(tabelaDeServicoDTO.getDataServico());
		tabelaDeServico.setServicoPrestado(tabelaDeServicoDTO.getServicoPrestado());
		tabelaDeServico.setValorServico(tabelaDeServicoDTO.getValorServico());
		
		return tabelaDeServico;
	}
		//buscar por ID
	
	public TabelaDeServicoDTO buscarPorId(Integer idtabelaDeServico) throws TabelaDeServicoExcpetion{
		Optional<TabelaDeServico> tabelaDeServico = tabelaDeServicoRepository.findById(idtabelaDeServico);
		TabelaDeServico tabelaDeServicoNovo = new TabelaDeServico();
		TabelaDeServicoDTO tabelaDeServicoDTO = new TabelaDeServicoDTO();
		
		if(tabelaDeServico.isPresent()) {
			tabelaDeServicoNovo = tabelaDeServico.get();
			tabelaDeServicoDTO = modelEmDTO(tabelaDeServicoDTO, tabelaDeServicoNovo);
	
		return tabelaDeServicoDTO;
		
	}

	
		throw new TabelaDeServicoExcpetion("Tabela De Servico não encontrada.");
			
	}
	
	
	//atualizar 
	
	public void atualizar (Integer idtabelaDeServico, TabelaDeServicoDTO tabelaDeServicoDTO ) {
		Optional<TabelaDeServico> tabelaDeServico = tabelaDeServicoRepository.findById(idtabelaDeServico);
		TabelaDeServico tabelaDeServicoNovo = new TabelaDeServico();	
		
		if(tabelaDeServico.isPresent()) {
			tabelaDeServicoNovo = tabelaDeServico.get();
			if(tabelaDeServicoDTO.getDataServico() !=null) {
				tabelaDeServicoNovo.setDataServico(tabelaDeServicoNovo.getDataServico());
			}
			if(tabelaDeServicoDTO.getServicoPrestado() !=null) {
				tabelaDeServicoNovo.setServicoPrestado(tabelaDeServicoNovo.getServicoPrestado());
			}
			if(tabelaDeServicoDTO.getValorServico() !=null) {
				tabelaDeServicoNovo.setValorServico(tabelaDeServicoNovo.getValorServico());
			}
		}
		
	}
		//delete
		public void delete (Integer idtabelaDeServico) {
			tabelaDeServicoRepository.deleteById(idtabelaDeServico);
		}
		
		//listar
		public List<TabelaDeServico> listarTodos(){
			return  tabelaDeServicoRepository.findAll();
		
	}
	
		public List<RelatorioDTO> relatorio(){
			return tabelaDeServicoRepository.buscarUltimosServicos();
			
		}
	
	
	
	
	
}