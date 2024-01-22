package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to iNeuron technologies";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}

	@GetMapping("/user")
	public String user() {
		return "Welcome User";
	}
}
