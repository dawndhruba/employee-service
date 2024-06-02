package djd.boot.employee.service.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeServiceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) {
		ErrorDetails excDetails = new ErrorDetails("We ran into some issues while processing your request. Please reach out to system admin for help.");
		excDetails.getMessages().add(new MessageDetail(ex.getMessage()));
		
		return new ResponseEntity<ErrorDetails>(excDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("There are some invalid information in the request.");
		
		List<MessageDetail> collect = ex.getFieldErrors().stream().map(error -> new MessageDetail(error.getDefaultMessage())).collect(Collectors.toList());
		errorDetails.setMessages(collect);
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
