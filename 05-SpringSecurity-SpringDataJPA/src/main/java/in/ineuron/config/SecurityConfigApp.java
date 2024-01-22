package in.ineuron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.ineuron.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encode);
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/bank/").permitAll()
				.requestMatchers("/user/register","/user/showLogin").permitAll()
				.requestMatchers("/bank/offers").authenticated()
				.requestMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")
				.requestMatchers("/bank/loanApprove").hasAuthority("MANAGER")
				.anyRequest().authenticated().and().formLogin()
				.defaultSuccessUrl("/bank/")
				.loginPage("/user/showLogin")
				.loginProcessingUrl("/login")
				.failureUrl("/user/showLogin?error")
				.and().rememberMe()
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				.logoutSuccessUrl("/user/showLogin?logout")
				.and().exceptionHandling().accessDeniedPage("/denied")
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true); 
				
				
		return http.build();
	}

}
