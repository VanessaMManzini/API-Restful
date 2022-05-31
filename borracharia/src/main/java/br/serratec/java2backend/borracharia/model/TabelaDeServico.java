package br.serratec.java2backend.borracharia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TabelaDeServico")
public class TabelaDeServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tabelaDeServico_cd_idTabela")
	private Integer idServico;
	
	@Column(name="tabelaDeServico_tx_servicoPrestadoTabela")
	private String servicoPrestado;
	
	@Column(name="tabelaDeServico_tx_dataServicoTabela")
	private Date dataServico;
	
	@Column(name="tabelaDeServico_num_valorServicoTabela")
	private Double valorServico;
	
	@ManyToOne
	@JoinColumn(name="carro_id", referencedColumnName ="carro_idCarro")
	private Carro carro;
	
		
	public TabelaDeServico () {}


	public Integer getIdServico() {
		return idServico;
	}


	public Carro getCarro() {
		return carro;
	}


	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public void setId(Integer idServico) {
		this.idServico = idServico;
	}


	public String getServicoPrestado() {
		return servicoPrestado;
	}


	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}


	public Date getDataServico() {
		return dataServico;
	}


	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}


	public Double getValorServico() {
		return valorServico;
	}


	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
	
	
}
