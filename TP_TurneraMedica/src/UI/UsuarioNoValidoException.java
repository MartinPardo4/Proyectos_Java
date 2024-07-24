package UI;

public class UsuarioNoValidoException extends Exception{

	public UsuarioNoValidoException() {
		super();
	}

	public UsuarioNoValidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioNoValidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioNoValidoException(String message) {
		super(message);
	}

	public UsuarioNoValidoException(Throwable cause) {
		super(cause);
	}
	
	
}
