package in.ineuron.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Autowired
	private DataSource source;
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(source)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
		
	}
	
	
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		http.authorizeRequests(request->request.requestMatchers("/api/")
				.permitAll().requestMatchers("/api/admin/").hasRole("ADMIN")
				.requestMatchers("/api/user/").hasAnyRole("ADMIN","USER")
				.anyRequest()
				.authenticated())
		.formLogin();
		return http.build();
	}

}
