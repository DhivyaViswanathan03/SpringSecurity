package in.ineuron.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Autowired
	public void configureAuthorities(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("divs").password("{noop}Welcome@123")
		.roles("CUSTOMER");
		builder.inMemoryAuthentication().withUser("mouli").password("{noop}Mouli@123")
		.roles("MANAGER");
		
	}
	
	@SuppressWarnings({ "deprecation", "removal" })
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/offers").authenticated()
		.requestMatchers("/balance").hasAnyRole("MANAGER","CUSTOMER")
		.requestMatchers("/loanApprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().rememberMe().and().logout().and()
		.exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		return http.build();
	}
	


}
