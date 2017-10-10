package sef.exceptions;

public class DataAccessException extends RuntimeException{

	private static final long serialVersionUID = 260512241753022015L;

	public DataAccessException(String message, Throwable source){
		super(message, source);
	}

}
