package br.serratec.java2backend.borracharia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_cd_idCliente")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nomeCliente")
	private String nome;
	
	@Column(name="cliente_tx_cpfCliente")
	private String cpf;
	
	@Column(name="cliente_nu_telefoneCliente")
	private Integer numero_Telefone;
	
	@Column(name="cliente_tx_emailCliente")
	private String email;

	
	@OneToMany(mappedBy= "cliente")
	private List<Carro> listaCarro;
	
	
	public Cliente () {}


	
	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}




	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getNumero_Telefone() {
		return numero_Telefone;
	}


	public void setNumero_Telefone(Integer numero_Telefone) {
		this.numero_Telefone = numero_Telefone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}


	

	
	
	
}
