package in.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/","/home","/login").permitAll()
		.anyRequest().authenticated().and().formLogin()
		.and().oauth2Login();
		return http.build();
	}

}
