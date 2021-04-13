package mm.errorExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionAdviceController {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorDescription> handleException(CustomerException e) {
		
		CustomerErrorDescription error = new CustomerErrorDescription(HttpStatus.NOT_FOUND.value(), e.getMessage()); 
		
		return new ResponseEntity<CustomerErrorDescription>(error, HttpStatus.NOT_FOUND); 
	}
	
	
	@ExceptionHandler 
	public ResponseEntity<CustomerErrorDescription> handleException(RuntimeException e) {
		
		CustomerErrorDescription error = new CustomerErrorDescription(HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return new ResponseEntity<CustomerErrorDescription>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
}
