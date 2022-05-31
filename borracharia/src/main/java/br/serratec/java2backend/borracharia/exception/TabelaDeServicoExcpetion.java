package br.serratec.java2backend.borracharia.exception;


 public class TabelaDeServicoExcpetion extends Exception{

	
    public TabelaDeServicoExcpetion() {
    	super();
    }

    public TabelaDeServicoExcpetion(String message) {
        super(message);
    }

    public TabelaDeServicoExcpetion(String message, Exception cause) {
        super(message, cause);
    }

    public TabelaDeServicoExcpetion(Exception e) {
        super(e);
    }
}

