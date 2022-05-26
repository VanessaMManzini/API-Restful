package br.serratec.javab2backend.projeto04.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.serratec.javab2backend.projeto04.exception.TodoException;
import br.serratec.javab2backend.projeto04.model.Todo;


@Service
public class TodoService {
	
	
	@Value("${url.serratec}")
	private String urlSerratec;
	
	List<Todo> lista = new ArrayList<>();
	
	public void adicionar(Todo todo) {
		lista.add(todo);		
	}
	 
	public List<Todo> listaTodo(){
		return this.lista;
}
	public void atualizar(Integer posicaoLista, Todo todoDaApi) {
		Todo todoDaListaSalva = new Todo();
		todoDaListaSalva = lista.get(posicaoLista);
		
		todoDaListaSalva.setId(todoDaApi.getId());
		todoDaListaSalva.setDescricao(todoDaApi.getDescricao());
		todoDaListaSalva.setTitulo(todoDaApi.getTitulo());
	}
		
	public Todo buscarPorId(int idTodo) throws TodoException  {
		Todo todoNoBanco = new Todo();
		for (Todo todo:lista) {
			if(todo.getId().equals(idTodo)){
				todoNoBanco = todo;
			}
		}
		
			if(todoNoBanco.getId() == null) {
			throw new TodoException(idTodo);
		}
			return todoNoBanco;
	}

	public void deletar(int posicaoLista) {
		
	}

	
	}

	

