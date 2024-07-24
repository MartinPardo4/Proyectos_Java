package Service;

public class EnlistarException extends Exception{

	public EnlistarException() {
		super();
	}

	public EnlistarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public EnlistarException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnlistarException(String message) {
		super(message);
	}

	public EnlistarException(Throwable cause) {
		super(cause);
	}
	
	
}
