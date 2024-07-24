package DAO;

public class ConsultaException extends EjecucionSentenciaException{

	public ConsultaException() {
		super();
	}

	public ConsultaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConsultaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConsultaException(String message) {
		super(message);
	}

	public ConsultaException(Throwable cause) {
		super(cause);
	}
	
	
}
