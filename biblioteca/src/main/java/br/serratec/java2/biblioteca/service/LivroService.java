package br.serratec.java2.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.java2.biblioteca.dto.LivroDto;
import br.serratec.java2.biblioteca.exception.LivroException;
import br.serratec.java2.biblioteca.model.Livro;
import br.serratec.java2.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public void salvar (LivroDto livroDto) throws LivroException {
		
		Livro livro = new Livro();
		Livro livroSalvar = new Livro();
		livroSalvar = transformarLivroDtoEmLivroModel (livroDto, livro);
		
		livroRepository.save(livroSalvar);
		
	}
		
		LivroDto transformarLivroModelEmLivroDto(LivroDto livroDto, Livro livro) {
		livroDto.setIdLivro(livro.getIdLivro());
		livroDto.setTitulo(livro.getTitulo());
		livroDto.setTipo(livro.getTipo());
		livroDto.setAutorLivro(livro.getAutorLivro());
		livroDto.setDataPublicacao(livro.getDataPublicacao());
		
		return livroDto;
			}
	
	public Livro transformarLivroDtoEmLivroModel(LivroDto livroDto, Livro livro) {

	//não seta id pq é automatico
		livro.setTitulo(livroDto.getTitulo());
		livro.setTipo(livroDto.getTipo());
		livro.setAutorLivro(livroDto.getAutorLivro());
		livro.setDataPublicacao(livroDto.getDataPublicacao());
		
		return livro;
	}	
	//buscar por ID
	public LivroDto buscarPorId(Integer IdLivro) throws LivroException{
		Optional<Livro> livro = livroRepository.findById(IdLivro);
		
		//livro vazio
		Livro livroNovo = new Livro();
		//litvoDto vazio
		LivroDto livroDto = new LivroDto();
	
		if(livro.isPresent()) {
			//livro vazio recebe o livroNovo
			livroNovo = livro.get();
			livroDto = transformarLivroModelEmLivroDto(livroDto, livroNovo);
			
			return livroDto;
		}
		throw new LivroException("Cliente nao encontrado");

	}
		//atualizar
	
		public void atualizar(Integer idLivro, LivroDto livroDto) {
			Optional<Livro> livro = livroRepository.findById(idLivro);
			Livro livroNovo = new Livro();
			
			if(livro.isPresent()) {
				livroNovo = livro.get();
				if(livroDto.getTitulo() !=null) {
							livroNovo.setTitulo(livroNovo.getTitulo());
				}
				if(livroDto.getTipo()!=null) {
					livroNovo.setTipo(livroNovo.getTipo());
				}
				if(livroDto.getAutorLivro() != null) {
					livroNovo.setAutorLivro(livroNovo.getAutorLivro());
				}
				if(livroDto.getDataPublicacao()!= null) {
					livroNovo.setDataPublicacao(livroNovo.getDataPublicacao());
				}
				livroRepository.save(livroNovo);
			}
		}
		//delete 
		public void delete(Integer idLivro) {
			livroRepository.deleteById(idLivro); //verificar pq nao esta indo com i minusculo
		}
			
		//listar
		public List<Livro> listarTodos(){
			return livroRepository.findAll();
		}
		
		
}

	
