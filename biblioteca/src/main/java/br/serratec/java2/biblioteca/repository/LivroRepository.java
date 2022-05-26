package br.serratec.java2.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.serratec.java2.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Integer> {  //Integer devido ao Id.

	
	
}
