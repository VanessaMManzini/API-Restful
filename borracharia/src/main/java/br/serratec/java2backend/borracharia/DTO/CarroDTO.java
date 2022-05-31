package br.serratec.java2backend.borracharia.DTO;

public class CarroDTO {
	
	private Integer idCarro;
	private String modelo;
	private String marca;
	private Integer anoFabricacao;
	private Integer idCliente;
	
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public CarroDTO () {}
	
		
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
