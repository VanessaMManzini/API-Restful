package br.serratec.java2.biblioteca.dto;

import java.util.Date;


public class LivroDto {
	
	
	private Integer idLivro;
	
	private String titulo;
	
	private String tipo;
	
	private String autorLivro;
	
	private Date dataPublicacao;
	
	
	
	public LivroDto() {}



	public Integer getIdLivro() {
		return idLivro;
	}



	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getAutorLivro() {
		return autorLivro;
	}



	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}



	public Date getDataPublicacao() {
		return dataPublicacao;
	}



	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
	

}
