package br.serratec.java2backend.borracharia.DTO;

import java.util.Date;

public class TabelaDeServicoDTO {


	private Integer idServico;
	private String servicoPrestado;
	private Date dataServico;
	private Double valorServico;
	private Integer idCarro;
	
	public TabelaDeServicoDTO() {}

	

	public Integer getIdServico() {
		return idServico;
	}



	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}



	public Integer getIdCarro() {
		return idCarro;
	}



	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
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
