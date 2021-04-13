package mm.errorExceptions;

public class CustomerException extends RuntimeException {
	
	
	public CustomerException() {} 
	
	public CustomerException(String message) {
		super(message); 
	}
	
	public CustomerException(Throwable cause) {
		super(cause); 
	}
	
	public CustomerException(String message, Throwable cause) {
		super(message, cause); 
	}
}
