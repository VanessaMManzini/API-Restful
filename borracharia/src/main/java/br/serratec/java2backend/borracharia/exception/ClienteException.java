package br.serratec.java2backend.borracharia.exception;


 public class ClienteException extends Exception{

	
    public ClienteException() {
    	super();
    }

    public ClienteException(String message) {
        super(message);
    }

    public ClienteException(String message, Exception cause) {
        super(message, cause);
    }

    public ClienteException(Exception e) {
        super(e);
    }
}
