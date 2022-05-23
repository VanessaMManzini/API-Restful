package br.serratec.java2backend.projeto06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.serratec.java2backend.projeto06.model.Conta;

//pela ordem o segundo pacote a ser feito é o repository

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer>{ //Integer pq o Id da Conta é integer

}
