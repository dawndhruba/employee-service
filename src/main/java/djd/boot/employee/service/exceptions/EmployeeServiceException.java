package djd.boot.employee.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = -8791974469795415994L;
	
	public EmployeeServiceException(String msg) {
		super(msg);
	}
	
}
