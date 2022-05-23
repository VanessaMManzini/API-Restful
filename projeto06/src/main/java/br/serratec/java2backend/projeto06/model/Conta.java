package br.serratec.java2backend.projeto06.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//pela ordem o primeiro pacote a ser feito é o model
@Entity
@Table(name ="conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id auto incrementado
	
	@Column(name="conta_cd_idConta")
	private Integer idConta;
	
	@Column(name="conta_tx_numeroConta")
	private Integer numeroConta;
	
	@Column(name="conta_tx_titularConta")
	private String titularConta;
	
	@Column(name="conta_nu_saldoConta")
	private float saldoConta;
	
	
	public Conta() {}
	//sempre usar um construtor vazio


	public Integer getIdConta() {
		return idConta;
	}


	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}


	public Integer getNumeroConta() {
		return numeroConta;
	}


	public void setNumero(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}


	public String getTitularConta() {
		return titularConta;
	}


	public void setTitular(String titularConta) {
		this.titularConta = titularConta;
	}


	public float getSaldoConta() {
		return saldoConta;
	}


	public void setSaldoConta(float saldoConta) {
		this.saldoConta = saldoConta;
	}

	
	
}


