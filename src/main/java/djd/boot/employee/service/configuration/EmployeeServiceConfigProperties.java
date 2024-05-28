package djd.boot.employee.service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "employee-service")
@Component
public class EmployeeServiceConfigProperties {
	private String legalEntity;
	private String legalEmployer;
	
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getLegalEmployer() {
		return legalEmployer;
	}
	public void setLegalEmployer(String legalEmployer) {
		this.legalEmployer = legalEmployer;
	}
}
