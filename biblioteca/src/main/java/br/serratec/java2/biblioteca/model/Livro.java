package br.serratec.java2.biblioteca.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//Entidade Livro
// Id - identificador (número, sequence, chave primária)
// titulo - titulo do livro (texto, obrigatório, minimo 5 e máximo 30 caracteres)
// tipo - tipo do livro (fantasia, técnico, romance) (texto, obrigatório, minimo 3 máximo 20)
// autor - nome do autor do livro (texto, obrigatorio, minimo 10, maximo 40)
//○ data de publicação - data de publicação do livro (deve ser uma data anterior a data atual

@Entity //identifica que a classe é uma entidade 
@Table(name="livro") // nome da tabela

public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_idLivro")
	private Integer idLivro;
	
	@Column(name = "livro_tx_titulo")
	@Size(min=5, max=30)
	@NotNull
	private String titulo;
	
	@Column(name = "livro_tx_tipo")
	@Size(min=3, max=20)
	@NotNull
	private String tipo;
	
	@Column(name ="livro_tx_autor")
	@Size(min=10, max=40)
	@NotNull
	private String autorLivro;
	
	@Column(name = "livro_dt_dataPublicacao")
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@Past(message = "A data deve estar no passado.")
	private Date dataPublicacao;
	
	public Livro() {} 

	//Getter e Setter
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

