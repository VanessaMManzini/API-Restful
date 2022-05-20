package org.serratec.java2backend.projetocrud.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projetocrud.model.Escola;


import org.springframework.stereotype.Service;



@Service
public class TodoService {

	
		
		List<Escola> lista = new ArrayList<Escola>();
		
		public void adicionar(Escola escola) {
			lista.add(escola);
		}
		
		public List<Escola> listaEscola(){
			return this.lista;
		}
		
		public void atualizar(int idPosicao, Escola infoEditada) {
			Escola escolaEditada = new Escola();
			
			escolaEditada = lista.get(idPosicao);
			
			escolaEditada.setId(infoEditada.getId());
			escolaEditada.setMateria(infoEditada.getMateria());
			escolaEditada.setProfessor(infoEditada.getProfessor());
		}
		
		public void deletar (int idPosicao) {
			lista.remove(idPosicao);
			
		}
}
