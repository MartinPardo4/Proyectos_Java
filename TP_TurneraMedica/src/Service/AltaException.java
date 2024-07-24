package Service;

public class AltaException extends Exception{

	public AltaException() {
		super();
	}

	public AltaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AltaException(String message, Throwable cause) {
		super(message, cause);
	}

	public AltaException(String message) {
		super(message);
	}

	public AltaException(Throwable cause) {
		super(cause);
	}
	
	
}
