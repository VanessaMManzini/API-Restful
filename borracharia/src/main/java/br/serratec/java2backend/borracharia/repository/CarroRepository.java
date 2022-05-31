package br.serratec.java2backend.borracharia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.serratec.java2backend.borracharia.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository <Carro, Integer>{

}
