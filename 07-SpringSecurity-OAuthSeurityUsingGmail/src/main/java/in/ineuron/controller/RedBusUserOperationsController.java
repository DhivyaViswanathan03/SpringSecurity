package in.ineuron.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserOperationsController {
	
	@GetMapping("/home")
	public String showHome() {
		return "Welcome to home Page";
	}
	
	@GetMapping("/after")
	public String afterLogin() {
		return "Successfully logged in";
	}
	
	@GetMapping("/user")
	public Authentication showDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}

}
