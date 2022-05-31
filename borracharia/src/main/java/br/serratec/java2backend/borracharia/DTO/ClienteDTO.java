package br.serratec.java2backend.borracharia.DTO;

public class ClienteDTO {
	
	private Integer idCliente;
	private String nome;
	private String cpf;
	private Integer numero_Telefone;
	private String email;

	
	public ClienteDTO () {}
	

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
