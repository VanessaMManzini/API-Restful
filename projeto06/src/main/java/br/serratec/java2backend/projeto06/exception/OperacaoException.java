package br.serratec.java2backend.projeto06.exception;

public class OperacaoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private float valor;
	
	public OperacaoException (float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
