package djd.boot.employee.service.security;

import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// all requests should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		// if authentication fails, a web page is shown
		http.httpBasic(withDefaults());
		
		// disable CSRF- to enable POST/PUT
		http.csrf().disable();
		
		return http.build();
	}
	
}
