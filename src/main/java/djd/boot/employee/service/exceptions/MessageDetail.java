package djd.boot.employee.service.exceptions;

public class MessageDetail {
	private String message;
	private String detail;
	
	public MessageDetail(String message) {
		this.message = message;
	}
	
	public MessageDetail(String message, String detail) {
		this.message = message;
		this.detail = detail;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
