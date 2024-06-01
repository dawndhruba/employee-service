package djd.boot.employee.service.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorDetails {
	private String summary;
	private List<MessageDetail> messages;
	
	public ErrorDetails(String summary) {
		this.summary = summary;
	}
	
	public ErrorDetails(String summary, List<MessageDetail> messages) {
		this.messages = messages;
	}
	
	public List<MessageDetail> getMessages() {
		if(this.messages == null) {
			messages = new ArrayList<MessageDetail>();
		}
		
		return messages;
	}
	
	public void setMessages(List<MessageDetail> messages) {
		this.messages = messages;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
