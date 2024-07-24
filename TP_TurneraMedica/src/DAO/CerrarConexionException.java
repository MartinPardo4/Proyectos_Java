package DAO;

public class CerrarConexionException extends ConexionException{

	public CerrarConexionException() {
		super();
	}

	public CerrarConexionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CerrarConexionException(String message, Throwable cause) {
		super(message, cause);
	}

	public CerrarConexionException(String message) {
		super(message);
	}

	public CerrarConexionException(Throwable cause) {
		super(cause);
	}
	
	
}
