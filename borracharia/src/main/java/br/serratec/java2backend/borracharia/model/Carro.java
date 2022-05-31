package br.serratec.java2backend.borracharia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="carro")
public class Carro implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="carro_idCarro")
	private Integer idCarro;
	
	@Column(name="carro_modeloCarro")
	private String modelo;
	
	@Column(name="carro_marcaCarro")
	private String marca;
	
	@Column(name="carro_anoFabricacaoCarro")
	private Integer anoFabricacao;
	
	
	@OneToMany(mappedBy = "carro")
	private List<TabelaDeServico> listaTabelaDeServico; 
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName = "cliente_cd_idCliente")
	@JsonIgnore
	private Cliente cliente;
		
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Carro() {}


	public Integer getIdCarro() {
		return idCarro;
	}


	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	
	
	
	
}
